package com.niit.skillmapper;

import static org.junit.Assert.assertEquals;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.skillmapper.config.AppContext;
import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.service.EmployeeService;


/**
 * Unit test for SkillMapper App.
 */
@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppContext.class)
public class AppTest 
{
	@Autowired
	private EmployeeService employeeService;
	
	@Before
	public void setup() {
		
		if(employeeService.findEmployeesByName("Amit")!=null) {
			employeeService.deleteEmployee(employeeService.findEmployeesByName("Amit").getEmpId());
		}
		
		if(employeeService.findEmployeesByName("Shital")!=null) {
			employeeService.deleteEmployee(employeeService.findEmployeesByName("Shital").getEmpId());
		}

		Employee emp1=new Employee();

		emp1.setName("Amit");
		emp1.setEmail("amitsbhati@gmail.com");
		emp1.setMobileNo("8696905284");
		emp1.setPassword("123456");
		emp1.setDob("1985-10-01");
		emp1.setIsMale(1);

		employeeService.addEmployee(emp1);
		
		Employee emp2=new Employee();
		emp2.setName("Shital");

		emp2.setEmail("shitalsolanki@gmail.com");
		emp2.setMobileNo("9874562148");
		emp2.setPassword("1111");
		emp2.setDob("1986-11-19");
		emp2.setIsMale(0);

		employeeService.addEmployee(emp2);
	}
	
	@After
	public void teardown() {
		employeeService.deleteEmployee(employeeService.findEmployeesByName("Amit").getEmpId());
		employeeService.deleteEmployee(employeeService.findEmployeesByName("shital").getEmpId());
		
	}
	
	
	@Test
	public void testAddEmployee() {
		
		Employee emp=new Employee();
		emp.setName("Ashok");

		emp.setEmail("ashoksinha@gmail.com");
		emp.setMobileNo("8795642541");
		emp.setPassword("1234");
		emp.setDob("1998-12-23");
		emp.setIsMale(1);

		assertEquals(true, employeeService.addEmployee(emp));
				
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void testAddEmployeeFailure() {
		
		Employee emp=new Employee();

		emp.setName("Amit");
		emp.setEmail("amitsbhati@gmail.com");
		emp.setMobileNo("7432567428");
		emp.setPassword("54321");
		emp.setDob("1992-01-01");
		emp.setIsMale(0);

		assertEquals(false, employeeService.addEmployee(emp));
				
	}

}
