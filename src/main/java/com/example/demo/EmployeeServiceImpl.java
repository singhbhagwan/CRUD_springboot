package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public EmployeeBean register(Employee emp) {
		// TODO Auto-generated method stub
		EmployeeBean bean=populateEmployeeBean(emp);
		//EmployeeBean e2=userRepository.save(bean);
		return  userRepository.save(bean);
	}

	private EmployeeBean populateEmployeeBean(Employee emp) {
		EmployeeBean bean=new EmployeeBean();
		bean.setName(emp.getName());
		
		return bean;
	}

	@Override
	public List<EmployeeBean> findAll() {
		// TODO Auto-generated method stub
		try {
		return (List<EmployeeBean>) userRepository.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
