package com.kncm.ratingservice.repository;


import com.kncm.ratingservice.model.HostGrade;
import com.kncm.ratingservice.model.User;

import java.util.List;


public interface HostGradeRepository extends EntityRepository<HostGrade>{

    List<HostGrade> findAllByGradeReceiver(User gradeReceiver);
    List<HostGrade> findAllByGradeGiverId(Long id);
    List<HostGrade> findAllByGradeReceiverId(Long id);
    List<HostGrade> findAllById(Long id);

}
