package com.reservei.courtsapi.service;

import com.reservei.courtsapi.domain.dto.CourtDto;
import com.reservei.courtsapi.domain.model.Court;
import com.reservei.courtsapi.domain.record.CourtData;
import com.reservei.courtsapi.repository.CourtRepository;
import com.reservei.courtsapi.service.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourtServiceImpl implements CourtService {

    @Autowired
    CourtRepository courtRepository;

    @Autowired
    CourtFactory courtFactory;

    @Autowired
    List<Validator> validators;

    @Override
    public CourtDto create(CourtData courtData) {
        Court court = courtFactory.of(courtData);

        validate(court);

        Court courtSaved = courtRepository.save(court);

        return CourtDto.toDto(courtSaved);
    }

    @Override
    public CourtDto findById(String id) {
        Court court = courtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quadra não encontrada"));

        return CourtDto.toDto(court);
    }

    @Override
    public CourtDto updateById(String id, CourtData data) {
        Court court = courtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quadra não encontrada"));
        court = courtFactory.update(court, data);
        Court courtUpdated = courtRepository.save(court);
        return CourtDto.toDto(courtUpdated);
    }

    private void validate(Court court) {
        for (Validator validator : validators) {
            validator.validate(court);
        }
    }

    public void setValidators(List<Validator> validators) {
        this.validators = validators;
    }
}
