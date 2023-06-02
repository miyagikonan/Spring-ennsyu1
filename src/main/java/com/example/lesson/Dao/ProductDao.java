package com.example.lesson.Dao;

import com.example.lesson.Record.ProductRecord;
import com.example.lesson.Record.ProductRecord2;
import com.example.lesson.Service.ProductService;

import java.util.List;

public interface ProductDao {
    public List<ProductRecord> findAll();

    public ProductRecord findById(int id);

    public int insert(ProductRecord2 productRecord);

    public int update(ProductRecord productupdate);

    public int delete(int id);
}
