package com.niit.skillmapper.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.model.Employee;

@Repository("employeeDAO")
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public List<Employee> findAll() {
		
		return sessionFactory.getCurrentSession()
				.createQuery("from Employee")
				.list();
	}

	public Employee findById(int empId) {
		
		return (Employee)sessionFactory.getCurrentSession()
				.createQuery("from Employee where empId="+empId)
				.uniqueResult();
		//return sessionFactory.getCurrentSession().get(Employee.class,empId);
	}

	public boolean addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return true;
	}

	public boolean updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return true;
	}

	public boolean deleteEmployee(int empId) {
		sessionFactory.getCurrentSession().delete(findById(empId));	
		return true;
	}
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public boolean suspendToggleEmployee(int empId, int isSuspend) {
		Session session=sessionFactory.getCurrentSession();	
		Query query = session.createQuery("update Employee set isSuspend = :isSuspend where empId = :EmpId ");
        query.setInteger("EmpId", empId);  
        query.setInteger("isSuspend", isSuspend);
        int result = query.executeUpdate();
        if(result>0)
        	return true;
        else
        	return false;
	}

	public Employee findByName(String name) {
		return (Employee)sessionFactory.getCurrentSession()
				.createQuery("from Employee where name='"+name+"'")
				.uniqueResult();
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	public boolean validateEmployee(Employee employee,int isApproved) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();	
		Query query = session.createQuery("update Employee set isApproved = :IsApproved where empId = :EmpId ");
        query.setInteger("IsApproved", isApproved);  
        query.setInteger("EmpId", employee.getEmpId());  
        int result = query.executeUpdate();
        if(result>0)
        	return true;
        else
        	return false;
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	public boolean authenticationEmployee(String emailId, String password) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();	
		Query query = session.createQuery("from Employee where isSuspend=0 and empRole=1 and email= :EmailId and password = :password");
        query.setString("EmailId", emailId);  
        query.setString("password", password);  
        if(query.uniqueResult()!=null)
        	return true;
        else
        	return false;
	}
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public boolean authenticationHR(String emailId, String password) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();	
		Query query = session.createQuery("from Employee where isSuspend=0 and empRole=2 and email= :EmailId and password = :password");
        query.setString("EmailId", emailId);  
        query.setString("password", password);  
        if(query.uniqueResult()!=null)
        	return true;
        else
        	return false;
	}
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public boolean authenticationEmployer(String emailId, String password) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();	
		Query query = session.createQuery("from Employee where isSuspend=0 and empRole=3 and email= :EmailId and password = :password");
        query.setString("EmailId", emailId);  
        query.setString("password", password);  
        if(query.uniqueResult()!=null)
        	return true;
        else
        	return false;
	}

	public List<Employee> filterEmployeeBySkills(String skills) {
		// TODO Auto-generated method stub
		return null;
	}

}
