package com.niit.skillmapper.dao;

import java.util.List;

import com.niit.skillmapper.model.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	public Employee findById(int empId);
	public Employee findByName(String name);
	public boolean addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int empId);
	public boolean suspendToggleEmployee(int empId , int isSuspend);
	public boolean validateEmployee(Employee employee,int isApproved);
	public boolean authenticationEmployee(String emailId, String password);
	public boolean authenticationHR(String emailId, String password);
	public boolean authenticationEmployer(String emailId, String password);
	public List<Employee>filterEmployeeBySkills(String skills);
}
