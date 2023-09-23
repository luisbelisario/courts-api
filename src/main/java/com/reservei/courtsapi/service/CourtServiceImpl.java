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
    public CourtDto createCourt(CourtData courtData) {
        Court court = courtFactory.of(courtData);

        validate(court);

        Court courtSaved = courtRepository.save(court);

        return CourtDto.toDto(courtSaved);
    }

    private void validate(Court court) {
        for (Validator validator : validators) {
            validator.validate(court);
        }
    }
}
