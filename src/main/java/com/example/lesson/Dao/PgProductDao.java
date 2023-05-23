package com.example.lesson.Dao;

import com.example.lesson.Exception.ProductNotFoundException;
import com.example.lesson.Record.ProductRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PgProductDao implements ProductDao {
    @Autowired
//    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate jdbcTemplate;

    //テーブルの一覧表示
    @Override
    public List<ProductRecord> findAll() {
        return jdbcTemplate.query("SELECT * FROM products2 ORDER BY id",
               new DataClassRowMapper<>(ProductRecord.class));
    }

    //idで指定したものの表示
    @Override
    public ProductRecord findById(int id) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id",id);

        var list = jdbcTemplate.query("SELECT * FROM products2 WHERE id = :id",
                parameterSource, new DataClassRowMapper<>(ProductRecord.class));

        if (list.isEmpty()) {
            throw new ProductNotFoundException("Product not found for ID: " + id);
        }

        return list.get(0);
    }

    //レコード追加
    @Override
    public int insert(ProductRecord productrecord) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id",productrecord.id());
        parameterSource.addValue("name",productrecord.name());
        parameterSource.addValue("price",productrecord.price());
        try {
            int insert = 0;
            insert = jdbcTemplate.update("INSERT INTO products2 VALUES (:id, :name, :price)" , parameterSource);
            return insert;
        } catch (Exception e) {
            System.out.println("インサートできませんでした");
        }
        return 0;
    }

    //レコードの更新
    @Override
    public int update(ProductRecord productupdate) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id",productupdate.id());
        parameterSource.addValue("name",productupdate.name());
        parameterSource.addValue("price",productupdate.price());
        int update = 0;
        update = jdbcTemplate.update("UPDATE products2 SET name = :name, price = :price WHERE id = :id",parameterSource);
        return update;
    }

    //レコードの削除
    @Override
    public int delete(int id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id",id);
        return jdbcTemplate.update("DELETE FROM products2 WHERE id = :id",parameterSource);
    }
}
