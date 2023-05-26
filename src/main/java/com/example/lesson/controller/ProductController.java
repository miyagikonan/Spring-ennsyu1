package com.example.lesson.controller;

import com.example.lesson.Service.ProductServiceImpl;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }


    @GetMapping("product-list")
        public String productList(Model model) {
            model.addAttribute("products", productService.findAll());
            return "product-list";
        }

    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product";
    }


}
