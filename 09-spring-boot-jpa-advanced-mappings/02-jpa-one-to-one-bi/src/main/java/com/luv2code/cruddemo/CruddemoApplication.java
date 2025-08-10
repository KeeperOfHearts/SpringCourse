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

//		Instructor instructor = new Instructor("Madhu" , "Patek", "madhu@luv2code.com");
//		InstructorDetail instructorDetail = new InstructorDetail(
//				"https://www.luv2code.com/youtube", "Guitar"
//		);
//
//		instructor.setInstructorDetail(instructorDetail);

//		Instructor instructor = findInstructor(appDAO);

//		deleteInstructor(appDAO);
		
		findInstructorDetail(appDAO);

	}

	private InstructorDetail findInstructorDetail(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor detail with id: " + id);
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		if (instructorDetail != null) {
			System.out.println("Found instructor detail: " + instructorDetail);
			System.out.println("Associated instructor: " + instructorDetail.getInstructor());
		} else {
			System.out.println("Instructor detail with id " + id + " not found.");
		}
		return instructorDetail;
	}

	private Instructor findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = appDAO.findById(id);
		if (instructor != null) {
			System.out.println("Found instructor: " + instructor);
		} else {
			System.out.println("Instructor with id " + id + " not found.");
		}
		return instructor;
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting instructor with id: " + id);
		appDAO.deleteById(id);
		System.out.println("Deleted instructor with id: " + id);
	}

}
