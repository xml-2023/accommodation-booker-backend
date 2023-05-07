package com.kncm.accommodationservice.service.image;

import com.kncm.accommodationservice.model.Image;

import java.util.List;

public interface ImageService {
    void save(List<Image> images, String name);
}
