package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/show")
	public String showForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employeeForm";
	}
	
	@PostMapping("/addEmployee")
	public String submitData(@ModelAttribute("employee") Employee employee) {
		employeeservice.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/delEmployee/{id}")
	public String deleteData(@PathVariable ("id") int id) {
		employeeservice.deleteById(id);
		return "redirect:/employees";
	}
	
	 
	 @GetMapping("/edit/{id}")
	    public String showEditUserForm(@PathVariable("id") int id, Model model) {
	        Employee employee = employeeservice.getUserById(id);
	        model.addAttribute("employee", employee);
	        return "employeeForm";
	    }

	@PostMapping("/updateEmployee")
		public String updateVal(@ModelAttribute("employee") Employee employee) {
			employeeservice.updatedEmpl(employee);
			//model.addAttribute("employee");
			return "redirect:/employees";
		}
	

}

 