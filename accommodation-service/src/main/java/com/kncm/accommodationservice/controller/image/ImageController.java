package com.kncm.accommodationservice.controller.image;

import com.kncm.accommodationservice.handler.exceptions.NoAvailableImagesException;
import com.kncm.accommodationservice.model.Image;
import com.kncm.accommodationservice.service.image.ImageService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accommodation/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImages(@RequestParam("file") List<MultipartFile> files, @RequestParam("name") String name) {
        List<Image> images = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                Image image = new Image();
                image.setName(file.getOriginalFilename());
                image.setContentType(file.getContentType());
                image.setData(file.getBytes());
                images.add(image);
            }

            imageService.save(images, name);

//            return ResponseEntity.ok().body("Images uploaded successfully!");
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image", e);
        }
    }

    //read images
    @GetMapping()
    public List<String> getAccommodationImageUrls(@RequestParam("name") String name) throws IOException {
        String path = "classpath:images/" + name + "/";
        Resource[] resources;
        try {
            resources = new PathMatchingResourcePatternResolver().getResources(path + "*.*");
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new NoAvailableImagesException();
        }
        List<String> urls = new ArrayList<>();
        for (Resource resource : resources) {
            String url = "data:" + Files.probeContentType(resource.getFile().toPath()) + ";base64," +
                    Base64.getEncoder().encodeToString(resource.getInputStream().readAllBytes());
            urls.add(url);
        }
        return urls;
    }
}
