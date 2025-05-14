package com.example.employee_Management_project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpController {

    @Autowired
    EmployeeService employeeService;

    //List<Employee> employees=new ArrayList<>();

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeService.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getAllEmployeeById(@PathVariable Long id){
        return employeeService.readEmployee(id);
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.deleteEmployee(id)){
            return "Deleted Successfully.";
        }
        return "Not Deleted.";
    }

    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }
}
