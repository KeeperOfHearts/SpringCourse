package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor instructor = new Instructor("Chad" , "Darby", "darby@luv2code.com");
//		InstructorDetail instructorDetail = new InstructorDetail(
//				"https://www.luv2code.com/youtube", "Luv 2 Code!!!"
//		);

		Instructor instructor = new Instructor("Madhu" , "Patek", "madhu@luv2code.com");
		InstructorDetail instructorDetail = new InstructorDetail(
				"https://www.luv2code.com/youtube", "Guitar"
		);

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);
	}

}
