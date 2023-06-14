package com.kncm.ratingservice.service.hostgrade;

import com.kncm.ratingservice.model.HostGrade;
import com.kncm.ratingservice.model.User;

public interface HostGradeService {
    void save(HostGrade grade);
    HostGrade findOne(Long id);
    void delete(HostGrade grade);
    boolean isHostGradeBigEnoughForDistinguishedStatus(User host);
}
