package com.example.lesson.controller;

import com.example.lesson.Record.ProductRecord;
import com.example.lesson.Record.ProductRecord2;
import com.example.lesson.form.productInsert;
import com.example.lesson.Service.ProductServiceImpl;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    //一覧表示
    @GetMapping("product-list")
        public String productList(Model model) {
            model.addAttribute("products", productService.findAll());
            return "product-list";
        }

        //idで表示
    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product";
    }

    //追加
    @GetMapping("/product-add")
    public String insert(@ModelAttribute("productInsert") productInsert productinsert) {
        return "product-add";
    }

    @PostMapping("/product-add")
    public String output(@Validated @ModelAttribute("productInsert") productInsert productinsert,
                         BindingResult bindingResult){

        String name = productinsert.getName();
        int price = productinsert.getPrice();
        ProductRecord2 record = new ProductRecord2(name,price);

        if (bindingResult.hasErrors()){
            return "product-add";
        }

        productService.insert(record);
        return "redirect:/product-list";
    }

    //更新
    @GetMapping("/update/{id}")
    public String up(@ModelAttribute("productInsert") productInsert productinsert, @PathVariable("id") int id, Model model) {
        productinsert = new productInsert();
        var findproduct = productService.findById(id);
//        model.addAttribute("product", findproduct);
        productinsert.setId(findproduct.id());
        productinsert.setName(findproduct.name());
        productinsert.setPrice(findproduct.price());
//        model.addAttribute("productInsert",productinsert);
        return "update";

    }


    @RequestMapping(value = "/update/{id}", params = "update",method = RequestMethod.POST)
    public String update(@Validated @ModelAttribute("productInsert") productInsert productinsert,
                         BindingResult bindingResult,
                         @PathVariable("id") int id,
                         Model model) {

        String name = productinsert.getName();
        int price = productinsert.getPrice();
        ProductRecord record = new ProductRecord(id,name,price);

        if (bindingResult.hasErrors()){
//            productinsert = new productInsert();
            var findproduct = productService.findById(id);
//            model.addAttribute("product", findproduct);
            productinsert.setId(findproduct.id());
            productinsert.setName(findproduct.name());
            productinsert.setPrice(findproduct.price());
//            model.addAttribute("productInsert",productinsert);
//            System.out.println("エラー");
//            System.out.println(bindingResult.getFieldError("name"));
            return "update";
        }

        productService.update(record);
        return "redirect:/product-list";
    }

    //削除
    @RequestMapping(value = "/update/{id}", params = "delete",method = RequestMethod.POST)
    @GetMapping("update")
    public String delete(@PathVariable("id") int id){
        productService.delete(id);
        return "redirect:/product-list";
    }

}
