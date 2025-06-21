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
