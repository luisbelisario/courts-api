package com.reservei.courtsapi.domain.dto;

import com.reservei.courtsapi.domain.enums.CourtCategory;
import com.reservei.courtsapi.domain.model.Court;
import com.reservei.courtsapi.domain.model.CourtAddress;
import com.reservei.courtsapi.domain.model.CourtAdmin;
import com.reservei.courtsapi.domain.model.CourtImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourtDto {

    private String id;

    private String courtName;

    private List<CourtCategory> courtCategories;

    private CourtAdmin courtAdmin;

    private CourtAddress courtAddress;

    private List<CourtImage> courtImages;

    private Double courtEvaluation;

    private LocalDate createdAt;

    public static CourtDto toDto(Court court) {
        CourtDto courtDto = new CourtDto();

        courtDto.setCourtName(court.getCourtName());
        courtDto.setCourtCategories(court.getCourtCategories());
        courtDto.setCourtAdmin(court.getCourtAdmin());
        courtDto.setCourtAddress(court.getCourtAddress());
        courtDto.setCourtImages(court.getCourtImages());
        courtDto.setCreatedAt(LocalDate.now());

        return courtDto;
    }
}
