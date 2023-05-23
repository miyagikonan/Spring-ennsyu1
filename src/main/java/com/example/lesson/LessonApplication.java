package com.example.lesson;

import com.example.lesson.Record.ProductRecord;
import com.example.lesson.Service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LessonApplication {

	public static void main(String[] args) {
		SpringApplication.run(LessonApplication.class, args);

		ConfigurableApplicationContext context =
				SpringApplication.run(LessonApplication.class,args);

		ProductService productService = context.getBean(ProductService.class);
		//テーブルの一覧表示
//		var list = productService.findAll();
//		list.stream().forEach(System.out::println);

		//idで指定したものの表示
//		var product = productService.findById(7);
//		System.out.println(product);

		//レコード追加
//		var insert = new ProductRecord(4,"ボールペン",300);
//		int result = productService.insert(insert);
//		System.out.println(result);

		//レコードの更新
//		var update = new ProductRecord(5,"ハサミ",200);
//		int result = productService.update(update);
//		System.out.println(result);

		//レコードの削除
//		var delete = productService.delete(5);
//		System.out.println(delete);
	}

}
