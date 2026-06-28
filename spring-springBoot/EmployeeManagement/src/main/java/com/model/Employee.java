package com.model;

import java.util.Objects;

public class Employee {
	
	
	private int empid;
	private String empName;
	private String empEmail;
	private String phoneNumber;
	private double salary;
	private boolean  isActive;
	
	
	
	
	
	
	
	
	
	public Employee(String empName, String empEmail, String phoneNumber, double salary) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	public Employee(int empid, String empName, String empEmail, String phoneNumber, double salary, boolean isActive) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.empEmail = empEmail;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.isActive = isActive;
		
	}
	
	
	
	

	public Employee(int empid, String empName, String empEmail, String phoneNumber, double salary) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.empEmail = empEmail;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public int hashCode() {
		return Objects.hash(empEmail, empName, empid, isActive, phoneNumber, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empEmail, other.empEmail) && Objects.equals(empName, other.empName)
				&& empid == other.empid && isActive == other.isActive && Objects.equals(phoneNumber, other.phoneNumber)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", empEmail=" + empEmail + ", phoneNumber="
				+ phoneNumber + ", salary=" + salary + ", isActive=" + isActive + "]";
	}
	
	

}
