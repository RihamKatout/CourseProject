package com.exalt.training.dao;


import com.exalt.training.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findALL();
}