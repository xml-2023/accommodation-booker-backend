package com.kncm.accommodationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("acc_prices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccommodationPrice {
    private Long id;
    private double value;
    private PricePurpose purpose;
    private PriceType type;
}
