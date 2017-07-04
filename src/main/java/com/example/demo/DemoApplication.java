package com.example.demo;

import com.example.demo.domain.Todo;
import com.example.demo.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private final TodoMapper todoMapper;

	public DemoApplication(TodoMapper todoMapper) {
		this.todoMapper = todoMapper; // Mapperをインジェクションする
	}

	// Spring Boot起動時にCommandLineRunner#runメソッドが呼び出される
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		Todo newTodo = new Todo();
		newTodo.setTitle("飲み会");
		newTodo.setDetails("銀座 19:00");

		todoMapper.insert(newTodo); // 新しいTodoをインサートする

		Todo loadedTodo = todoMapper.select(newTodo.getId()); // インサートしたTodoを取得して標準出力する
		System.out.println("ID       : " + loadedTodo.getId());
		System.out.println("TITLE    : " + loadedTodo.getTitle());
		System.out.println("DETAILS  : " + loadedTodo.getDetails());
		System.out.println("FINISHED : " + loadedTodo.isFinished());
	}
}
