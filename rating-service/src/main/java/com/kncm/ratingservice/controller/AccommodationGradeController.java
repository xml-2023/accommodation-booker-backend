package com.kncm.ratingservice.controller;

import com.kncm.ratingservice.service.accommodationgrade.AccommodationGradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rating")
@RequiredArgsConstructor
public class AccommodationGradeController {
    private AccommodationGradeService accommodationGradeService;
}
