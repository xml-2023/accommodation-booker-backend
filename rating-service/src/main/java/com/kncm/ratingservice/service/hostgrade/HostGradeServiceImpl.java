package com.kncm.ratingservice.service.hostgrade;

import com.kncm.ratingservice.model.HostGrade;
import com.kncm.ratingservice.model.User;
import com.kncm.ratingservice.repository.HostGradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public boolean isHostGradeBigEnoughForDistinguishedStatus(User host) {
        List<HostGrade> hostGrades = hostGradeRepository.findAllByGradeReceiver(host);
        double sum = 0;
        for (HostGrade hg : hostGrades) {
            sum += hg.getValue();
        }
        double averageGrade = sum / hostGrades.size();
        return averageGrade > 4.7;
    }
}
