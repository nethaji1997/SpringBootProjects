package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDaoImpl implements IEmployeeDao {

	private static final String GET_EMP_BY_DESG="Select * from employee where desg in(?,?,?) order by desg";
	
	@Autowired
	private DataSource ds;
	
	@Override
	public List<Employee> getEmpByDesg(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("EmployeeDaoImpl.getEmpByDesg()");
		List<Employee> list=null;
		
		try(Connection conn=ds.getConnection(); PreparedStatement ps=conn.prepareStatement(GET_EMP_BY_DESG))
		{
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3,desg3);
			
			try(ResultSet rs=ps.executeQuery())
			{
				list=new ArrayList<>();
				while(rs.next())
				{
					Employee emp=new Employee();
					emp.setEno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptno(rs.getInt(5));
					list.add(emp);
				}
			}
			
		}
		return list;
	}

}
