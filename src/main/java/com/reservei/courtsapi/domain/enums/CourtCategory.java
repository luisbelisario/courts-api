package com.reservei.courtsapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public enum CourtCategory {

    BASKET("Basquete"),
    TENNIS("TENNIS"),
    INDOOR_SOCCER("INDOOR_SOCCER"),

    BEACH_VOLLEY("BEACH_VOLLEY"),

    BEACH_TENNIS("BEACH_TENNIS");

    private String category;

    CourtCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
