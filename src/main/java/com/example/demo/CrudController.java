package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value="/register")
	
	public ResponseEntity<Object> register(@RequestBody Employee emp){
		System.out.println("dkgfkdfkj");
		EmployeeBean bean=employeeService.register(emp);
		return new ResponseEntity<>(bean,HttpStatus.CREATED);
	}
	
	
	@GetMapping(value="/getEmp")
	public ResponseEntity<Object> getEmp(){
		System.out.println("testing done");
		return new ResponseEntity<>(employeeService.findAll(),HttpStatus.OK);
	}
}
