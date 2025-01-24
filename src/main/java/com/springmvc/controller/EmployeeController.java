package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.Employee;
import com.springmvc.service.EmployeeService;

@Controller

public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeservice;
	
	
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeservice.getAllEmployees() );
		return "employeeList";
	}
	
	@GetMapping("/addEmployee")
	public String showForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employeeForm";
	}
	
	
	@PostMapping("/addEmployee")
	public String submitData(@ModelAttribute Employee employee) {
		
		employeeservice.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/delEmployee")
	public String deleteData(@RequestParam ("id") int id) {
		employeeservice.deleteById(id);
		return "redirect:/employees";
	}
	@PostMapping("/updateEmployee")
		public String updateVal(@ModelAttribute Employee employee) {
			employeeservice.updatedEmpl(employee);
			//model.addAttribute("employee");
			return "redirect:/employees";
		}
	

}

 