package com.kncm.ratingservice.service.accommodationgrade;

import com.kncm.ratingservice.model.AccommodationGrade;
import com.kncm.ratingservice.repository.AccommodationGradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccommodationGradeServiceImpl implements AccommodationGradeService{
    private final AccommodationGradeRepository accommodationGradeRepository;

    @Override
    public void save(AccommodationGrade grade) {
        accommodationGradeRepository.save(grade);
    }

    @Override
    public AccommodationGrade findOne(Long id) {
        return accommodationGradeRepository.findOne(id);
    }

    @Override
    public void delete(AccommodationGrade grade) {
        accommodationGradeRepository.delete(grade);
    }

    @Override
    public List<AccommodationGrade> findAllByUserId(Long id) {
        return accommodationGradeRepository.findAllByGradeGiverId(id);
    }

    @Override
    public List<AccommodationGrade> findAllByAccommodationId(Long id) {
        return accommodationGradeRepository.findAllByAccommodationId(id);
    }

    @Override
    public List<AccommodationGrade> findAllById(Long id) {
        return accommodationGradeRepository.findAllById(id);
    }

    @Override
    public Double getAccommodationAverageGrade(Long id) {
        List<AccommodationGrade> grades =  findAllByAccommodationId(id);
        Double sum = 0.0;
        for (AccommodationGrade grade : grades){
            sum+= grade.getValue();
        }
        return sum / grades.size();
    }
}
