package com.springmvc.controller;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.model.Employee;

@Controller
public class EmployeeController {
	
	Map<Integer,Employee> empdata = new HashMap<Integer,Employee>();
	

	@GetMapping(value = EmployeeURIConstants.TEST)
	public @ResponseBody Employee getDumyEmp() {
		Employee emp= new Employee();
		emp.setId(12);
		emp.setName("Rahul Garg");
		
		emp.setCreatedDate(new SimpleDateFormat("DD-MM-YY   HH:MM:SS").format(new Date()));
		
		empdata.put(1, emp);
		return emp;
	}
	
	@GetMapping(value= EmployeeURIConstants.GET_EMP)
	public @ResponseBody Employee getByid(@PathVariable("id") String id) {
		System.out.println("Called............");
		return empdata.get(id);
	}
	
	@GetMapping(value= EmployeeURIConstants.GET_ALL_EMP)
	@ResponseBody
	public Map getAllEmployee() {
		List<Employee> emp = new ArrayList<Employee>();
		
		Set<Integer> dataEmp = empdata.keySet();
		for(Integer  i :dataEmp) {
			emp.add(empdata.get(i));
		}
		return empdata;	
	}
	
	@PostMapping(value= EmployeeURIConstants.CREATE_EMPS)
	@ResponseBody
	public String listOfEmp() {
		
		for(int i=0;i<10;i++) {
			Employee e = new Employee();
			e.setId(i);
			e.setName("Gaurav"+i);
			e.setCreatedDate(new SimpleDateFormat("DD-MM-YY").format(new Date()));
			empdata.put(i, e);
		}
		return "Successfully inserted";
	}
	
	@DeleteMapping(value= EmployeeURIConstants.DELETE_EMP)
	public@ResponseBody Employee deleteEmp(@PathVariable("id") String id) {
		Employee e = empdata.get(id);
		empdata.remove(id);
		return e;
	}
	
}

 