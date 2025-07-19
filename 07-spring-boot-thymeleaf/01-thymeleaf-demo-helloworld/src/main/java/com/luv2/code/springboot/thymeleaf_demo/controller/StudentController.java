package com.luv2.code.springboot.thymeleaf_demo.controller;

import com.luv2.code.springboot.thymeleaf_demo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {

        Student theStudent = new Student();

        model.addAttribute("student", theStudent);

        model.addAttribute("countries", countries);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {


        return "student-confirmation";
    }
}
