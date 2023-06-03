package com.kncm.ratingservice.service.accommodationgrade;

import com.kncm.ratingservice.repository.AccommodationGradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccommodationGradeServiceImpl implements AccommodationGradeService{
    private AccommodationGradeRepository accommodationGradeRepository;
}
