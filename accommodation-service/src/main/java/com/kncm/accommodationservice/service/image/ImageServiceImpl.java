package com.kncm.accommodationservice.service.image;

import com.kncm.accommodationservice.model.Image;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    private static final String UPLOAD_DIR = "accommodation-service/src/main/resources/images";

    @Override
    public void save(List<Image> images, String name) {
        for (Image image : images) {
            try {
                // Save the image to the upload directory
                Path uploadPath = Paths.get(UPLOAD_DIR + "/" + name);
                Files.createDirectories(uploadPath);
                String filename = StringUtils.cleanPath(image.getName());
                Path filepath = uploadPath.resolve(filename);
                Files.write(filepath, image.getData());

            } catch (IOException e) {
                throw new RuntimeException("Failed to store image " + image.getName(), e);
            }
        }
    }
}
