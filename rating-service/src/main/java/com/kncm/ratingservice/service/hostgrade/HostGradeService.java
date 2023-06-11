package com.kncm.ratingservice.service.hostgrade;

import com.kncm.ratingservice.model.HostGrade;

public interface HostGradeService {
    void save(HostGrade grade);
    HostGrade findOne(Long id);
    void delete(HostGrade grade);
}
