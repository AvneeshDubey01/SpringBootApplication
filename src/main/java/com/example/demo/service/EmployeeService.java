// EmployeeService.java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    

    public Employee updateEmployee(Employee updatedEmployee) {
    	Employee e =null;
        if (employeeRepository.existsById(updatedEmployee.getId())) {
        	 e =employeeRepository.save(updatedEmployee);
        	 
            
        }
        return e;
         // Handle not found scenario
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}

