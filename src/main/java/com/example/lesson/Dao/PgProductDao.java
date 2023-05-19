package com.example.lesson.Dao;

import com.example.lesson.Record.ProductRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PgProductDao implements ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ProductRecord> findAll() {
        return jdbcTemplate.query("SELECT * FROM products2 OREDER BY id",
               new DataClassRowMapper<>(ProductRecord.class));
    }
}
