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

    public static BreedEnum findById(Integer identifier) {
        BreedEnum result = null;
        for (BreedEnum breed : values()) {

            if (identifier == breed.identifier) {
                result = breed;
                break;
            }
        }
        return result != null ? result : OTHER;
    }

    public BreedEnum findByName(String name) {
        BreedEnum result = null;
        for (BreedEnum breed : values()) {

            if (breed.name().equalsIgnoreCase(name)) {
                result = breed;
                break;
            }
        }
        return result != null ? result : OTHER;
    }

    public int getIdentifier() {
        return this.identifier;
    }
}
