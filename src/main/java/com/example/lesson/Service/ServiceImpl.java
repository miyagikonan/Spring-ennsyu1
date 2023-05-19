package com.example.lesson.Service;

import com.example.lesson.Dao.ProductDao;
import com.example.lesson.Record.ProductRecord;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ServiceImpl implements Service {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductRecord> findAll() {
        return productDao.findAll();
    }
}
