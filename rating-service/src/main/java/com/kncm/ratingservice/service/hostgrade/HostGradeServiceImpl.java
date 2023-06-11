package com.kncm.ratingservice.service.hostgrade;

import com.kncm.ratingservice.model.HostGrade;
import com.kncm.ratingservice.repository.HostGradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HostGradeServiceImpl implements HostGradeService{
    private final HostGradeRepository hostGradeRepository;

    @Override
    public void save(HostGrade grade) {
        hostGradeRepository.save(grade);
    }

    @Override
    public HostGrade findOne(Long id) {
        return hostGradeRepository.findOne(id);
    }

    @Override
    public void delete(HostGrade grade) {
        hostGradeRepository.delete(grade);
    }
}
