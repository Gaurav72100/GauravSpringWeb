package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.EmployeeDAO;
import com.springmvc.model.Employee;



@Service
@Transactional
public class EmployeeService {

	@Autowired
	private final EmployeeDAO employeedao;
	
	public EmployeeService(EmployeeDAO employeedao) {
		this.employeedao=employeedao;
	}
	
	
	public void saveEmployee(Employee employee) {
		employeedao.save(employee);
	}
	public List<Employee>  getAllEmployees(){
		return employeedao.getAllEmployees();
	}
	
	public void updatedEmpl(Employee employee) {
		 employeedao.updateEmp(employee);
	}


	public void deleteById(int id) {
		 employeedao.delete(id);
	}
}
