package com.reservei.courtsapi.domain.record;

import com.reservei.courtsapi.domain.enums.CourtCategory;
import com.reservei.courtsapi.domain.model.CourtAddress;
import com.reservei.courtsapi.domain.model.CourtAdmin;
import com.reservei.courtsapi.domain.model.CourtImage;

import java.util.List;

public record CourtData(
        String courtName,

        List<CourtCategory> courtCategories,

        CourtAdmin courtAdmin,

        CourtAddress courtAddress,

        List<CourtImage> courtImages) {
}
