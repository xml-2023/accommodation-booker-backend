package com.kncm.ratingservice.service.hostgrade;

import com.kncm.ratingservice.model.AccommodationGrade;
import com.kncm.ratingservice.model.HostGrade;
import com.kncm.ratingservice.model.User;

import java.util.List;

public interface HostGradeService {
    void save(HostGrade grade);
    HostGrade findOne(Long id);
    void delete(HostGrade grade);
    boolean isHostGradeBigEnoughForDistinguishedStatus(User host);
    List<HostGrade> findAllByGuestId(Long id);
    List<HostGrade> findAllByHostId(Long id);
    List<HostGrade> findAllById(Long id);
    Double getHostAverageGrade(Long id);
}
