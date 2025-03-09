package com.nt.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Employee {

	private Integer eno;
	private String ename;
	private String desg;
	private Double salary;
	private Integer deptno;
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", desg=" + desg + ", salary=" + salary + ", deptno="
				+ deptno + "]";
	}
	
	
}
