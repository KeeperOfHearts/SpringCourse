package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRESTController {

    private List<Student> theStudents ;


    @PostConstruct
    private void loadData()    {
        // create the students
        theStudents = new ArrayList<>();

        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Roman", "Zui"));
        theStudents.add(new Student("Wilson", "Smith"));
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp((int) System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp((int) System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        if (id < 0 || id >= theStudents.size()) {
            throw new StudentNotFoundException("Student id not found - " + id);
        }
        return theStudents.get(id);
    }

}
