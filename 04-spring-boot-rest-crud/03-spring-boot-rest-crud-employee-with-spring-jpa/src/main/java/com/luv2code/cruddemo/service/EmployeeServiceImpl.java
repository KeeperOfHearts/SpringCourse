package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.luv2code.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository EmployeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository EmployeeRepository) {
        this.EmployeeRepository = EmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return EmployeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employeeOptional = EmployeeRepository.findById(id);

        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        } else {
            throw new RuntimeException("Employee id not found - " + id);
        }
    }

    @Override
    public Employee save(Employee employee) {
        return EmployeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        EmployeeRepository.deleteById(id);
    }
}
