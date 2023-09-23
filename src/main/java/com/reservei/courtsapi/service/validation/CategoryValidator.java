package com.reservei.courtsapi.service.validation;

import com.reservei.courtsapi.domain.enums.CourtCategory;
import com.reservei.courtsapi.domain.model.Court;

import java.util.List;

public class CategoryValidator implements Validator {


    @Override
    public void validate(Court court) {
        if (court.getCourtCategories() == null ||
                court.getCourtCategories().isEmpty() ||
                !validateCategories(court.getCourtCategories())) {
            throw new RuntimeException("Invalid Categories");
        }
    }

    private boolean validateCategories(List<CourtCategory> courtCategories) {
        for (CourtCategory c : courtCategories) {
            try {
                CourtCategory.valueOf(c.getCategory());
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return true;
    }
}
