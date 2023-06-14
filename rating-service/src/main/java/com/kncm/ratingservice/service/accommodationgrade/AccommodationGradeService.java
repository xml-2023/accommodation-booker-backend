package com.kncm.ratingservice.service.accommodationgrade;

import com.kncm.ratingservice.model.AccommodationGrade;

import java.util.List;

public interface AccommodationGradeService {
    void save(AccommodationGrade grade);
    AccommodationGrade findOne(Long id);
    void delete(AccommodationGrade grade);
    List<AccommodationGrade> findAllByUserId(Long id);
    List<AccommodationGrade> findAllByAccommodationId(Long id);
    List<AccommodationGrade> findAllById(Long id);
    Double getAccommodationAverageGrade(Long id);
}
