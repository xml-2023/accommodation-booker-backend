package com.kncm.accommodationservice.controller.image;

import com.kncm.accommodationservice.model.Image;
import com.kncm.accommodationservice.service.image.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

            return ResponseEntity.ok().body("Images uploaded successfully!");

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image", e);
        }
    }

    //read images
//    @GetMapping("/images")
//    public List<String> getImageUrls() throws IOException {
//        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath*:images/*.*");
//        List<String> urls = new ArrayList<>();
//        for (Resource resource : resources) {
//            String url = "data:" + Files.probeContentType(resource.getFile().toPath()) + ";base64," +
//                    Base64.getEncoder().encodeToString(IOUtils.toByteArray(resource.getInputStream()));
//            urls.add(url);
//        }
//        return urls;
//    }
}