package com.exalt.training.controller;

import com.exalt.training.dao.EmployeeDAO;
import com.exalt.training.entity.Employee;
import com.exalt.training.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

//    private EmployeeDAO employeeDAO;
    private EmployeeService employeeService;

//    public EmployeeRestController(EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }


    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> getAllEmployees(){
//        return employeeDAO.findALL();
        return employeeService.findAll();
    }
}