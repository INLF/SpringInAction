package com.eldar.vesna.controllers;

import com.eldar.vesna.data.FakeDAOIngredients;
import com.eldar.vesna.data.Ingredient;
import com.eldar.vesna.data.Taco;
import com.eldar.vesna.data.TacoOrder;
import com.eldar.vesna.repos.IngredientRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
@RequestMapping(value = "/design")
@SessionAttributes("tacoOrder")
public class TacoDesignController {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public TacoDesignController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
        Ingredient.Type [] types = Ingredient.Type.values();
        for (Ingredient.Type t : types) {
            model.addAttribute(
                    t.toString().toLowerCase(),
                    filterByType(t , ingredients));
        }
    }
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder tacoOrder() {
        return new TacoOrder();
    }
    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }
    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco ,
                              Errors errors,
                              @ModelAttribute TacoOrder tacoOrder) {
        if (errors.hasErrors()) {
            return "design";
        }
        tacoOrder.addTaco(taco);
        log.info("Processing taco {}" , taco);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(Ingredient.Type type , Iterable<Ingredient> ingredients) {
        var stream = StreamSupport.stream(ingredients.spliterator() , false);
        return stream.filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
