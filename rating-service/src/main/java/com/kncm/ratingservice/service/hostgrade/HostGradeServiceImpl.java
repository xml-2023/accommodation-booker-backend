package com.kncm.ratingservice.service.hostgrade;

import com.kncm.ratingservice.repository.HostGradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HostGradeServiceImpl implements HostGradeService{
    private HostGradeRepository hostGradeRepository;
}
