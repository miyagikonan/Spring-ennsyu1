package com.example.lesson.Dao;

import com.example.lesson.Record.ProductRecord;
import java.util.List;

public interface ProductDao {
    public List<ProductRecord> findAll();
}
