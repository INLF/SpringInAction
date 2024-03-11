package com.eldar.vesna.data;

import lombok.Data;

@Data
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;
    public enum Type {
        WRAP,
        VEGGIES,
        PROTEIN,
        SAUCE
    }
}
