package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.entity.eleves;
import com.demo.repository.elevesRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	public elevesRepository elevesrepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		/* eleves n = new eleves("bon","bonbon","gon@gmail.com");
		elevesrepository.save(n);
		*/
	}
	

}