package com.alurachallenge.library;

import com.alurachallenge.library.main.Main;
import com.alurachallenge.library.repository.BookRepository;
import com.alurachallenge.library.service.ConvertData;
import com.alurachallenge.library.service.UseAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	public void showMain(){
		Main main = new Main(repository);
		main.showMenu();
	}
@Autowired
private BookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception{

		System.out.println("--------INICIANDO APLICACION--------");

		showMain();

		System.out.println("------------------------------------");
	}
}
