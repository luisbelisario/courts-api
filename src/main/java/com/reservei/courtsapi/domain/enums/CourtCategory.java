package com.reservei.courtsapi.domain.enums;

public enum CourtCategory {

    BASKET("Basquete"),
    TENNIS("Tênis"),
    INDOOR_SOCCER("Futsal"),

    BEACH_VOLLEY("Vôlei de praia"),

    BEACH_TENNIS("Beach tênis");

    private String category;

    CourtCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
