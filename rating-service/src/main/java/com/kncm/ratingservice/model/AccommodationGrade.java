package com.kncm.ratingservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "accommodation-grades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccommodationGrade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer value;
    private LocalDateTime ratingDate;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private User gradeGiver;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private Accommodation accommodation;
}
