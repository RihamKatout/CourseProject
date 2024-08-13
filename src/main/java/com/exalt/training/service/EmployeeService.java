package com.exalt.training.service;

import com.exalt.training.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}