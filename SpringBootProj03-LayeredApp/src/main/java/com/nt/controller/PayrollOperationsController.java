package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller("payroll")
public class PayrollOperationsController {

	@Autowired
	private IEmployeeMgmtService service;

	public List<Employee> showEmpByDesg(String desg1, String desg2, String desg3) throws Exception
	{
		System.out.println("PayrollOperationsController.showEmpByDesg()");
		List<Employee> fetchEmpByDesgInService = service.fetchEmpByDesgInService(desg1, desg2, desg3);
		return fetchEmpByDesgInService;
	}
}
