package com.reservei.courtsapi.service;

import com.reservei.courtsapi.domain.dto.CourtDto;
import com.reservei.courtsapi.domain.record.CourtData;
import org.springframework.stereotype.Service;

@Service
public interface CourtService {

    CourtDto create(CourtData courtData);
    CourtDto findById(String id);
    CourtDto updateById(String id, CourtData data);

}
