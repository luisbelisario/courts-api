package com.reservei.courtsapi.domain.model;

import com.reservei.courtsapi.domain.enums.CourtCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("courts")
public class Court {

    @Id
    private String id;

    private String courtName;

    private List<CourtCategory> courtCategories;

    private CourtAdmin courtAdmin;

    private CourtAddress courtAddress;

    private List<CourtImage> courtImages;

    private Double courtEvaluation;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}
