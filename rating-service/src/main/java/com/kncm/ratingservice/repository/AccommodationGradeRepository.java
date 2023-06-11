package com.kncm.ratingservice.repository;

import com.kncm.ratingservice.model.AccommodationGrade;

import java.util.List;

public interface AccommodationGradeRepository extends EntityRepository<AccommodationGrade>{
    List<AccommodationGrade> findAllByGradeGiverId(Long id);
    List<AccommodationGrade> findAllByAccommodationId(Long id);
}
