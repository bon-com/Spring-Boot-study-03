package com.example.demo05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo05.domain.Customer;
import com.example.demo05.repository.CustomerRepository;

@SpringBootApplication
public class Demo05Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Demo05Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 全検索
		System.out.println("全件検索------------------");
		repository.findAll().forEach(c -> System.out.println("出力： " + c));

		// 1件検索
		System.out.println("1件検索------------------");
		Customer res = repository.findById(1).orElse(null);
		System.out.println("出力： " + res);

		// 1件追加
		System.out.println("1件追加------------------");
		Customer c1 = new Customer();
		c1.setFirstName("三郎");
		c1.setLastName("鈴木");
		Customer created = repository.save(c1);

		// 1件更新
		System.out.println("1件更新------------------");
		created.setFirstName("太郎");
		created.setLastName("変更");
		repository.save(created);

		// 全検索
		System.out.println("全件検索------------------");
		repository.findAll().forEach(c -> System.out.println("出力： " + c));

		// 1件削除
		System.out.println("1件削除------------------");
		repository.delete(created);

		// 全検索
		System.out.println("全件検索------------------");
		repository.findAll().forEach(c -> System.out.println("出力： " + c));
		
		// カスタムした全検索
		System.out.println("IDの降順全検索------------------");
		repository.findAllOrderByIdDesc().forEach(c -> System.out.println("出力： " + c));
		
		// カスタムした名前検索
		System.out.println("1件名前検索------------------");
		Customer res2 = repository.findByFirstName("太郎");
		System.out.println(res2);
		
		// カスタムした苗字検索
		System.out.println("1件苗字検索------------------");
		Customer res3 = repository.findByLastName("佐藤");
		System.out.println(res3);
		
		// 複数登録
		System.out.println("複数登録------------------");
		List<Customer> inputCustomers = new ArrayList<>();
		Arrays.asList(1, 2, 3).forEach(i -> {
			Customer customer = new Customer();
			customer.setLastName("テスト" + i);
			customer.setFirstName("太郎");
			inputCustomers.add(customer);
		});
		repository.saveAll(inputCustomers);
		
		// 全検索
		System.out.println("全件検索------------------");
		repository.findAll().forEach(c -> System.out.println("出力： " + c));
		
		// 全削除
		repository.deleteAll(inputCustomers);
		
	}

}
