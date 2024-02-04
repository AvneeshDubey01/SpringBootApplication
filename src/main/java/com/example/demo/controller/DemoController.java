package com.example.demo.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.NotFoundException;
@RequestMapping // can be added or ignored no problem 
@RestController
public class DemoController {
	@Autowired
	private final EmployeeService esl;
	
	public DemoController(EmployeeService esl) {
		this.esl=esl;
	}
	
	@GetMapping("/")
	public String getMessage() {
		return "It will work this time";
	}
	
	
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees(){
		return this.esl.getAllEmployees() ;
	}
	
	@GetMapping("/{id}")  // 
	Employee getEmployeeById(@PathVariable Integer id){
		return this.esl.getEmployeeById(id);
		
	}
	
	@PostMapping("/add")
	public String createEmployee(@RequestBody Employee employee) {
		Employee e = esl.createEmployee(employee);
		return "added"; 
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee updatedEmployee) {
		Employee e = esl.updateEmployee(updatedEmployee);
		if(e!=null)
			return e;
		else
			throw new NotFoundException("Employee not Found");
	}
	
	
}

// All the hibernate annotations 
//Transactions 


