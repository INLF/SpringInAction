package com.eldar.vesna.repos.impl;

import com.eldar.vesna.data.Ingredient;
import com.eldar.vesna.repos.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JDBCIngredientRepository implements IngredientRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query(
                "select id , name , type from Ingredient" ,
                this::mapRowToIngredients);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> results = jdbcTemplate.query(
                "select id , name , type from Ingredient where id=?",
                this::mapRowToIngredients,
                id);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.getFirst());
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "insert into Ingredients (id , name , type) values (? , ? , ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString()
        );
        return ingredient;
    }

    private Ingredient mapRowToIngredients(ResultSet row , int rowNum) throws SQLException {
        return new Ingredient(
                row.getString("id") ,
                row.getString("name") ,
                Ingredient.Type.valueOf(row.getString("type")));
    }
}
