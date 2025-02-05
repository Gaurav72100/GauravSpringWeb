package com.springmvc.controller;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.model.Employee;

@Controller
public class EmployeeController {
	
	HashMap<Integer,Employee> empdata = new HashMap<Integer,Employee>();
	

	@GetMapping(value=EmployeeURIConstants.TEST)
	public @ResponseBody Employee getDumyEmp() {
		Employee emp= new Employee();
		emp.setId(12);
		emp.setName("Rahul Garg");
		
		emp.setCreatedDate(new SimpleDateFormat("DD-MM-YY   HH:MM:SS").format(new Date()));
		
		empdata.put(1, emp);
		return emp;
	}
	
}

 