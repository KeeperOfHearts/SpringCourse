package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
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
//			createInstructor(appDAO);

//			Instructor instructor = findInstructor(appDAO);

//			deleteInstructor(appDAO);

//			findInstructorDetail(appDAO);

//			deleteInstructorDetail(appDAO);

//			createInstructorWIthCourses(appDAO);

//			findInstructorWithCourses(appDAO);

//			findCoursesForInstructor(appDAO);
			
//			findInstructorWithCoursesJoinFetch(appDAO);

			updateInstructor(appDAO);
		};
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 3;
		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = appDAO.findById(id);
		if (instructor != null) {
			System.out.println("Found instructor: " + instructor);
			instructor.setFirstName("Heather");
			appDAO.update(instructor);
			System.out.println("Updated instructor: " + instructor);
		} else {
			System.out.println("Instructor with id " + id + " not found.");
		}
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 3;
		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		if (instructor != null) {
			System.out.println("Found instructor: " + instructor);
			System.out.println("Courses: " + instructor.getCourses());
		} else {
			System.out.println("Instructor with id " + id + " not found.");
		}
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int instructorId = 3;
		System.out.println("Finding courses for instructor with id: " + instructorId);
		var courses = appDAO.findCoursesByInstructorId(instructorId);
		if (courses != null && !courses.isEmpty()) {
			System.out.println("Found courses: " + courses);
		} else {
			System.out.println("No courses found for instructor with id " + instructorId);
		}
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 3;
		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = appDAO.findById(id);
		if (instructor != null) {
			System.out.println("Found instructor: " + instructor);
			System.out.println("Courses: " + instructor.getCourses());
		} else {
			System.out.println("Instructor with id " + id + " not found.");
		}
	}

	private void createInstructorWIthCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Susan" , "Public", "susan@luv2code.com");
		InstructorDetail instructorDetail = new InstructorDetail(
				"https://eee.youtube.com", "Video Games"
		);
		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Air Guitar - The Ultimate Guide");

		Course course2 = new Course("The Pinball Masterclass");

		instructor.addCourse(course1);
		instructor.addCourse(course2);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());

		appDAO.save(instructor);


	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor instructor = new Instructor("Max" , "Danno", "danno@luv2code.com");
//		InstructorDetail instructorDetail = new InstructorDetail(
//				"https://www.luv2code.com/youtube", "Luv 2 Code!!!"
//		);
//		instructor.setInstructorDetail(instructorDetail);
//
//		System.out.println("Saving instructor: " + instructor);
//		appDAO.save(instructor);

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

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 6;
		System.out.println("Deleting instructor detail with id: " + id);
		appDAO.deleteInstructorDetailById(id);
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
		int id = 4;
		System.out.println("Deleting instructor with id: " + id);
		appDAO.deleteById(id);
		System.out.println("Deleted instructor with id: " + id);
	}

}
