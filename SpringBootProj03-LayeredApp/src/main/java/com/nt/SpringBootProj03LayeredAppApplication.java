package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class SpringBootProj03LayeredAppApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx=SpringApplication.run(SpringBootProj03LayeredAppApplication.class, args);
		PayrollOperationsController payrollOperationsController = ctx.getBean(PayrollOperationsController.class);
		List<Employee> showEmpByDesg = payrollOperationsController.showEmpByDesg("clerk", "manager", "salesman");
		showEmpByDesg.forEach(emp->System.out.println(emp));
		((ConfigurableApplicationContext) ctx).close();
	}
}
