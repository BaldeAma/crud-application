package com.formation.crud_application.controller;


import com.formation.crud_application.exception.ResourceNotFoundException;
import com.formation.crud_application.model.Employee;
import com.formation.crud_application.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    //getAll employee
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //create employee rest api
    @PostMapping("/employees")
    public  Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //get  employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee= employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exit with id: "+id));
        return ResponseEntity.ok(employee);
    }

    //update employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeedetails){
        // check if employee exist
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exit with id: "+id));

        employee.setEmailId(employeedetails.getEmailId());
        employee.setFirstName(employeedetails.getFirstName());
        employee.setLastName(employeedetails.getLastName());

        return ResponseEntity.ok(employeeRepository.save(employee));
    }

}
