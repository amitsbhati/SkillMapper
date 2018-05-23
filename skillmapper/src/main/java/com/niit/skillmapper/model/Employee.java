package com.niit.skillmapper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nEmpId")
	private int empId;
	
	@NonNull
	@Column(name="emp_name")
	private String name;
	
	@NonNull
	@Column(name="emailId",unique=true)
	private String email;
	
	@NonNull
	private String mobileNo;
	
	@NonNull
	private String password;
	
	@Nullable
	private String skills;
	
	@Nullable
	private int isSuspend;
	
	@NonNull
	private int isMale;
	
	@NonNull
	private String dob;
	

	private String address;

	private String empLocation;

	private String qualification;

	private String empExperience;

	private String empDept;

	private String empDesg;

	private int empRole;

	private String empCerti;

	private int isApproved;

	private String photo;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}



	public int getIsSuspend() {
		return isSuspend;
	}

	public void setIsSuspend(int isSuspend) {
		this.isSuspend = isSuspend;
	}

	public int getIsMale() {
		return isMale;
	}

	public void setIsMale(int isMale) {
		this.isMale = isMale;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmpLocation() {
		return empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getEmpExperience() {
		return empExperience;
	}

	public void setEmpExperience(String empExperience) {
		this.empExperience = empExperience;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public String getEmpDesg() {
		return empDesg;
	}

	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}

	public int getEmpRole() {
		return empRole;
	}

	public void setEmpRole(int empRole) {
		this.empRole = empRole;
	}

	public String getEmpCerti() {
		return empCerti;
	}

	public void setEmpCerti(String empCerti) {
		this.empCerti = empCerti;
	}

	public int getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(int isApproved) {
		this.isApproved = isApproved;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	

}
