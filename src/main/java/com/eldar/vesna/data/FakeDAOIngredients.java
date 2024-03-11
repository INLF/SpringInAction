package com.eldar.vesna.data;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
@Getter
public class FakeDAOIngredients {
    private final List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("FLTO" , "Flour Tortilla" , Ingredient.Type.WRAP),
            new Ingredient("COTO" , "Corn Tortilla" , Ingredient.Type.WRAP),
            new Ingredient("BEEF" , "Beef chops" , Ingredient.Type.PROTEIN),
            new Ingredient("PORK" , "Pork chops" , Ingredient.Type.PROTEIN),
            new Ingredient("TOMT" , "Diced Tomatoes" , Ingredient.Type.VEGGIES),
            new Ingredient("CUCM" , "Cucumbers" , Ingredient.Type.VEGGIES),
            new Ingredient("KTCH" , "Ketchup" , Ingredient.Type.SAUCE),
            new Ingredient("SOUR" , "Sour Cream" , Ingredient.Type.SAUCE)
    );

}
