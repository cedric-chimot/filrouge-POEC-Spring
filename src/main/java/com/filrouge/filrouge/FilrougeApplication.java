package com.filrouge.filrouge;

import com.filrouge.filrouge.data.DataCreate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class FilrougeApplication {

	@Autowired
	private DataCreate dataCreate;

	public static void main(String[] args) {
		SpringApplication.run(FilrougeApplication.class, args);
	}

	@PostConstruct
	public void createData() {
		dataCreate.newData();
	}
}
