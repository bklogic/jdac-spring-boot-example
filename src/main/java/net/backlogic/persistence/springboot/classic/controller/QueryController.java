package net.backlogic.persistence.springboot.classic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.backlogic.persistence.springboot.classic.model.Customer;
import net.backlogic.persistence.springboot.classic.model.Employee;
import net.backlogic.persistence.springboot.classic.model.ProductLine;
import net.backlogic.persistence.springboot.classic.repository.ClassicQuery;


@RestController
public class QueryController {

	@Autowired
	ClassicQuery query;
	
	@RequestMapping("/getProductLines")
	@ResponseBody
	List<ProductLine> getProductLines() {
		return query.getProductLines();
	}
	
	@RequestMapping("/getEmployees")
	@ResponseBody
	List<Employee> getEmployees() {
		return query.getEmployees();
	}
	
	@RequestMapping("/getCustomer")
	@ResponseBody
	Customer getEmployees(@RequestParam int customerNumber) {
		return query.getCustomer(customerNumber);
	}
	
}
