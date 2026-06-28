package com.entity;

import java.util.Objects;

public class Emplopyees {
	
	
	private int empid;
	private String empname;
	private int salary;

	
	
	
	
	public Emplopyees() {
		super();
	}
	public Emplopyees(int empid, String empname, int salary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.salary = salary;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public int hashCode() {
		return Objects.hash(empid, empname, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emplopyees other = (Emplopyees) obj;
		return empid == other.empid && Objects.equals(empname, other.empname) && salary == other.salary;
	}
	@Override
	public String toString() {
		return "Emplopyees [empid=" + empid + ", empname=" + empname + ", salary=" + salary + "]";
	}
	
	

}
