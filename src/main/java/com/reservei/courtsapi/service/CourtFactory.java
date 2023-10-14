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

    public Court update(Court court, CourtData courtData) {

        court.setCourtName(courtData.courtName() != null ? courtData.courtName() : court.getCourtName());
        court.setCourtCategories(courtData.courtCategories() != null ? courtData.courtCategories() : court.getCourtCategories());
        court.setCourtAdmin(courtData.courtAdmin() != null ? courtData.courtAdmin() : court.getCourtAdmin());
        court.setCourtAddress(courtData.courtAddress() != null ? courtData.courtAddress() : court.getCourtAddress());
        court.setCourtImages(courtData.courtImages() != null ? courtData.courtImages() : court.getCourtImages());
        court.setCourtEvaluation(court.getCourtEvaluation());
        court.setUpdatedAt(LocalDate.now());

        return court;
    }
}
