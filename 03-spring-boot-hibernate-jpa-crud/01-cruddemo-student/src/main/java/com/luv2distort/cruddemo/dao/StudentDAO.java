package com.luv2distort.cruddemo.dao;

import com.luv2distort.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);
}
