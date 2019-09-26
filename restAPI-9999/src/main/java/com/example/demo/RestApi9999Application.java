package com.example.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
public class RestApi9999Application {


	
	
	public static void main(String[] args) {
		SpringApplication.run(RestApi9999Application.class, args);
		
	
	
		System.out.print("Test Project start!");
		
	}

}
