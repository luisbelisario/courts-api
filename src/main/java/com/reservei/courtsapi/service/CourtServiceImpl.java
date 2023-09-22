package com.reservei.courtsapi.service;

import com.reservei.courtsapi.domain.dto.CourtDto;
import com.reservei.courtsapi.domain.model.Court;
import com.reservei.courtsapi.domain.record.CourtData;
import com.reservei.courtsapi.repository.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourtServiceImpl implements CourtService {

    @Autowired
    CourtRepository courtRepository;

    @Autowired
    CourtFactory courtFactory;

    @Override
    public CourtDto createCourt(CourtData courtData) {
        Court court = courtFactory.of(courtData);

        Court courtSaved = courtRepository.save(court);

        return CourtDto.toDto(courtSaved);
    }
}
