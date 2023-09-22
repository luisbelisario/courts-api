package com.reservei.courtsapi.service;

import com.reservei.courtsapi.domain.dto.CourtDto;
import com.reservei.courtsapi.domain.record.CourtData;
import org.springframework.stereotype.Service;

@Service
public interface CourtService {

    public CourtDto createCourt(CourtData courtData);
}
