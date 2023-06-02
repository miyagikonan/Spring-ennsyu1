package com.example.lesson.form;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class productInsert {

    private int id;
    @NotEmpty(message = "商品名は必須入力です。")
    @Length(min=1,max=50)
    private String name;

    @Digits(integer = 10,fraction = 0)
    @Min(value = 0)
    @Max(value = Integer.MAX_VALUE)
    @NotNull(message = "値段は必須入力です。")
    private int price;

    public productInsert(){}
}
