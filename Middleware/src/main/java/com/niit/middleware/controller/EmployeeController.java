package com.niit.middleware.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.service.EmployeeService;


@RestController
@RequestMapping("api/employee")
public class EmployeeController {

@Autowired
EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployees()
	{
		List<Employee> employees=employeeService.findAllEmployees();
		if(employees!=null)
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		else
			return new ResponseEntity<String>("No Employee found", HttpStatus.NO_CONTENT);
	}
	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee)
	{
		boolean status=employeeService.addEmployee(employee);
		return new ResponseEntity<String>("Employee Saved Successfully", HttpStatus.CREATED);
	}
	@PostMapping("/delete/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int empId)
	{
		boolean status=employeeService.deleteEmployee(empId);
		return new ResponseEntity<String>("Employee Deleted",HttpStatus.OK);
	}
	@GetMapping("/employee/{empId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable int empId)
	{
		Employee emp=employeeService.findEmployeesById(empId);
		if(emp!=null)
		{
			return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No Employee Found with given id",HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/employee/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp)
	{
			employeeService.updateEmployee(emp);
			return new ResponseEntity<String>("Record Updated",HttpStatus.OK);

	}
	@PostMapping("/employee/login")
	public ResponseEntity<?> checkLoginEmployee(@RequestBody Employee employee, HttpSession httpSession)
	{
		boolean status=employeeService.authenticateEmployee(employee.getEmail(), employee.getPassword());
		if(status)
		{
			httpSession.setAttribute("empId", employee.getEmpId());
		    return new ResponseEntity<String>("Welcome", HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<String>("Invalid credentials",HttpStatus.NOT_FOUND);
		}
	}
}
