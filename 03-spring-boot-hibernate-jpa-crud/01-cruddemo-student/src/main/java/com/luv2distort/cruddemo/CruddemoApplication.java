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
//		 	createMultipleStudent(studentDAO);

			readStudent(studentDAO);
		};

	}

	private void readStudent(StudentDAO studentDAO) {
		Student retrievedStudent = studentDAO.findById(1);
		System.out.println("Found the student: " + retrievedStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("Przemek", "Thowohkow", "PRZ23@luv2code.com");
		Student tempStudent2 = new Student("Roman", "Czugajewski", "ROM16@luv2code.com");
		Student tempStudent3 = new Student("Piotr", "Prondzynski", "PIPR12@luv2code.com");

		// inject students objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


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
