package com.springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.Employee;

@Repository
public class EmployeeDAO {
	
	@Autowired
	private final  HibernateTemplate hibernateTemplate;
	
	public EmployeeDAO( HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate=hibernateTemplate;
	}
	
	@Transactional
	public void save(Employee employee) {
		hibernateTemplate.save(employee);
	}
	
	@Transactional
	public List<Employee> getAllEmployees(){
	       return	hibernateTemplate.loadAll(Employee.class);
	}
	
	@Transactional
	public void delete(int id) {
		Employee employee = hibernateTemplate.load(Employee.class, id);
		if(employee != null) {
			 hibernateTemplate.delete(employee);
		}
	    
	}
	
	
	@Transactional
	public void updateEmp(Employee employee) {
		hibernateTemplate.update(employee);
	}

}

