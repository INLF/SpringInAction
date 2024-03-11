package com.eldar.vesna.data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Taco {
    @NotNull
    @Size(min=1 , message = "You must choose at least 1 ingredient!")
    private List<Ingredient> ingredients;

    @NotNull
    @Size(max = 20 , min = 5 , message = "Name must be at range of 5 to 20 characters!")
    private String name;

    private String id;


}
