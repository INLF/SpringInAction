package com.eldar.vesna.converters;

import com.eldar.vesna.data.FakeDAOIngredients;
import com.eldar.vesna.data.Ingredient;
import com.eldar.vesna.repos.impl.JDBCIngredientRepository;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class IngredientByIdConverter implements Converter<String , Ingredient> {
    private final JDBCIngredientRepository jdbcIngredientRepository;
    @Autowired
    public IngredientByIdConverter(JDBCIngredientRepository jdbcIngredientRepository) {
        this.jdbcIngredientRepository = jdbcIngredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
        var ingredient = jdbcIngredientRepository.findById(id);
        return ingredient.orElse(null);
    }
}
