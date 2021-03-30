package com.accenture.gqldemo.enums;

public enum BreedEnum {

    CUCKOO(1),
    GOLDEN_CUCKOO(2),
    BLACK(3),
    BIRCHEN(4),
    BLACK_COPPER(5),
    WHEATEN(6),
    BLACK_TAILED_BUFF(7),
    WHITE(8),
    COLUMBIAN(9),
    OTHER(99);

    private int identifier;

    private BreedEnum(int identifier) {
        this.identifier = identifier;
    }

    private BreedEnum findByName(String name) {
        BreedEnum result = null;
        for (BreedEnum breed : values()) {

            if (breed.name().equalsIgnoreCase(name)) {
                result = breed;
                break;
            }
        }
        return result != null ? result : OTHER;
    }
}
