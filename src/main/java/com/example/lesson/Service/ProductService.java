package com.example.lesson.Service;
import com.example.lesson.Record.ProductRecord;

import java.util.List;

public interface ProductService {
    public List<ProductRecord> findAll();

    public ProductRecord findById(int id);

    public int insert(ProductRecord productrecord);

    public int update(ProductRecord productupdate);

    public int delete(int id);
}
