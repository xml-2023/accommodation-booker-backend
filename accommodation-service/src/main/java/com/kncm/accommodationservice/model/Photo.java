package com.kncm.accommodationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("photos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
    private Long id;
    private String path;
}
