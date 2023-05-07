package com.kncm.accommodationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
//    private Long id;
//    private String path;
    private String name;
    private String contentType;
    private byte[] data;
}
