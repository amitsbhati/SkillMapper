package com.niit.skillmapper.service;

import java.util.List;

import com.niit.skillmapper.model.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployees();
	public Employee findEmployeesById(int empId);
	public Employee findEmployeesByName(String name);
	public boolean addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int empId);
	public boolean suspendToggleEmployee(int empId , int isSuspend);
	public boolean validateEmployee(Employee employee,int isApproved);
	public boolean authenticateEmployee(String emailId, String password);
	public boolean authenticateHR(String emailId, String password);
	public boolean authenticateEmployer(String emailId, String password);
}
