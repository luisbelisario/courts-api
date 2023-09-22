package com.reservei.courtsapi.service;

import com.reservei.courtsapi.domain.model.Court;
import com.reservei.courtsapi.domain.record.CourtData;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CourtFactory {

    public Court of(CourtData courtData) {
        Court court = new Court();

        court.setCourtName(courtData.courtName());
        court.setCourtCategories(courtData.courtCategories());
        court.setCourtAdmin(courtData.courtAdmin());
        court.setCourtAddress(courtData.courtAddress());
        court.setCourtImages(courtData.courtImages());
        court.setCourtEvaluation(0.0);
        court.setCreatedAt(LocalDate.now());
        court.setUpdatedAt(null);

        return court;
    }
}
