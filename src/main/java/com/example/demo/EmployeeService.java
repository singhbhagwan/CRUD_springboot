package com.example.demo;

import java.util.List;

public interface EmployeeService {

	public EmployeeBean register(Employee emp);
	public List<EmployeeBean> findAll();
}
