package com.example.lesson.Service;
import com.example.lesson.Record.ProductRecord;
import com.example.lesson.Record.ProductRecord2;

import java.util.List;

public interface ProductService {
    public List<ProductRecord> findAll();

    public ProductRecord findById(int id);

    public int insert(ProductRecord2 productRecord);

    public int update(ProductRecord productupdate);

    public int delete(int id);
}
