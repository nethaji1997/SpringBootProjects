package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDao;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeDao empDao;

	@Override
	public List<Employee> fetchEmpByDesgInService(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> empByDesg = empDao.getEmpByDesg(desg1, desg2, desg3);
		return empByDesg;
	}

}
