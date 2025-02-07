
package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.model.Employee;
import com.springmvc.service.EmployeeService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/i")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeservice;
	
	
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeservice.getAllEmployees() );
		return "employeeList";
	}
	
	@GetMapping(value = "/emp")
	@ResponseBody
	public List<Employee> getEmp(){
		
		return  employeeservice.getAllEmployees();
	}
	 
	
	@PostMapping("/addEmployee")
	@ResponseBody
	public String submitData(@ModelAttribute Employee employee,Model model) {
		System.out.println("EmployeeController.submitData()");
		//System.out.println(employee.getEmail());
		employeeservice.saveEmployee(employee);
		return "Successfull";
	}
	
	@GetMapping("/delEmployee/{id}")
	public String deleteData(@PathVariable ("id") int id) {
		employeeservice.deleteById(id);
		return "redirect:/employees";
	}
	
	
	@GetMapping("/login") 
	@ResponseBody
	public String login(@RequestParam String email) {
       
		for(String emp:employeeservice.emails()) {
			if(emp.equals(email)) {
				System.out.println("Found"+ emp);
				break;
			}
			else {
				System.out.println("NOt Found");
			}
		}
		return "Successful" ;
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

 