package com.eldar.vesna.repos.impl;

import com.eldar.vesna.data.TacoOrder;
import com.eldar.vesna.repos.TacoOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTacoOrderRepository implements TacoOrderRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCTacoOrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<TacoOrder> findAll() {
//        jdbcTemplate.query(
//                "select " ,
//        );
        return null;
    }

    @Override
    public TacoOrder save(TacoOrder order) {

        return null;
    }
}
