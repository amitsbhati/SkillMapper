package com.niit.skillmapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.skillmapper.dao.EmployeeDAO;
import com.niit.skillmapper.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO employeeDAO;
	
	public List<Employee> findAllEmployees() {
		
		return employeeDAO.findAll();
	}

	public Employee findEmployeesById(int empId) {
		
		return employeeDAO.findById(empId);
	}

	public boolean addEmployee(Employee employee) {
		
		if(employeeDAO.findById(employee.getEmpId())!=null) {
			return false;
		}
		else {
			employeeDAO.addEmployee(employee);
			return true;
		}
	}

	public boolean updateEmployee(Employee employee) {
		if(employeeDAO.findById(employee.getEmpId())!=null) {	
			employeeDAO.updateEmployee(employee);
			return true;
		}
		else {
			return false;
		}
	}

	public boolean deleteEmployee(int empId) {
		if(employeeDAO.findById(empId)!=null) {	
			employeeDAO.deleteEmployee(empId);
			return true;
		}
		else {
			return false;
		}
	}

	public Employee findEmployeesByName(String name) {
		
		return employeeDAO.findByName(name);
	}

	public boolean suspendToggleEmployee(int empId, int isSuspend) {
		
		return employeeDAO.suspendToggleEmployee(empId, isSuspend);
	}

	public boolean validateEmployee(Employee employee, int isApproved) {
		
		return employeeDAO.validateEmployee(employee, isApproved);
	}

	public boolean authenticateEmployee(String emailId, String password) {
		
		return employeeDAO.authenticationEmployee(emailId,password);
	}

	public boolean authenticateHR(String emailId, String password) {
		
		return employeeDAO.authenticationHR(emailId,password);
	}

	public boolean authenticateEmployer(String emailId, String password) {

		return employeeDAO.authenticationEmployer(emailId,password);
	}

}
