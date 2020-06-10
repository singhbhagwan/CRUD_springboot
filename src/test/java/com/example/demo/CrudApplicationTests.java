package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(PowerMockRunner.class)
@PrepareForTest(CrudController.class)
@AutoConfigureMockMvc
class CrudApplicationTests {

	
	@InjectMocks
	CrudController crudController = new CrudController();
	
	@Mock
	EmployeeService employeeService;

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		System.out.println("choooooot");
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(crudController).build();
		/*
		 * MockitoAnnotations.initMocks(this);
		 * mockMvc=MockMvcBuilders.standaloneSetup(crudController).build();
		 */
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testRegisterEmployee() throws Exception {
		
		List<EmployeeBean> empBean = new ArrayList<>();
		EmployeeBean emp = new EmployeeBean();
		emp.setId(1L);
		emp.setName("bhagwan singh1");
		empBean.add(emp);
		
		Employee empDto=new Employee();
		empDto.setName("bhagwan"); 
		
		Mockito.when(employeeService.findAll()).thenReturn(empBean);
		String json = mapper.writeValueAsString(empDto);
		System.out.println(json);
		mockMvc.perform(MockMvcRequestBuilders.post("/register").content(json).contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated());
		

	}

}
