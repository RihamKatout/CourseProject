package com.exalt.training.dao;


import com.exalt.training.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findALL();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}