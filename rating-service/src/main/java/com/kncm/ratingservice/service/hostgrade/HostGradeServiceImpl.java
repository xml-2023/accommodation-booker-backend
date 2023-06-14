package com.kncm.ratingservice.service.hostgrade;

import com.kncm.ratingservice.model.AccommodationGrade;
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

    @Override
    public List<HostGrade> findAllByGuestId(Long id) {
        return hostGradeRepository.findAllByGradeGiverId(id);
    }

    @Override
    public List<HostGrade> findAllByHostId(Long id) {
        return hostGradeRepository.findAllByGradeReceiverId(id);
    }

    @Override
    public List<HostGrade> findAllById(Long id) {
        return hostGradeRepository.findAllById(id);
    }

    @Override
    public Double getHostAverageGrade(Long id) {
        List<HostGrade> grades =  findAllByHostId(id);
        Double sum = 0.0;
        for (HostGrade grade : grades){
            sum+= grade.getValue();
        }
        return sum / grades.size();
    }
}
