package com.luv2distort.cruddemo;

import com.luv2distort.cruddemo.dao.StudentDAO;
import com.luv2distort.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
		 	createStudent(studentDAO);
		};

	}

	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating a new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// inject student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display created student id
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
