package com.example.lesson.Service;

import com.example.lesson.controller.ProductController;
import com.example.lesson.Dao.PgProductDao;
import com.example.lesson.Dao.ProductDao;
import com.example.lesson.Exception.ProductNotFoundException;
import com.example.lesson.Record.ProductRecord;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    //テーブルの一覧表示
    @Override
    public List<ProductRecord> findAll() {
        return productDao.findAll();
    }

    //idで指定したものの表示
    @Override
    public ProductRecord findById(int id) {
        return productDao.findById(id);
    }

    //レコード追加
    @Override
    public int insert(ProductRecord productrecord){
        return productDao.insert(productrecord);
    }

    //レコードの更新
    @Override
    public int update(ProductRecord productupdate) {
        return productDao.update(productupdate);
    }

    @Override
    public int delete(int id) {
        return productDao.delete(id);
    }
}
