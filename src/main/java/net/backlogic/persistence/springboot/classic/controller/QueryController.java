package net.backlogic.persistence.springboot.classic.controller;

import net.backlogic.persistence.client.DataAccessClient;
import net.backlogic.persistence.springboot.classic.model.BatchQueryResult;
import net.backlogic.persistence.springboot.classic.model.Customer;
import net.backlogic.persistence.springboot.classic.model.Employee;
import net.backlogic.persistence.springboot.classic.repository.BatchQuery;
import net.backlogic.persistence.springboot.classic.repository.ClassicQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("query")
public class QueryController {

	@Autowired
	private ClassicQuery query;
	@Autowired 
	private DataAccessClient client;

	@GetMapping("/getCustomer/{customerNumber}")
	@ResponseBody
	public Customer getCustomer(@PathVariable int customerNumber) {
		return query.getCustomer(customerNumber);
	}

	@GetMapping("/getCustomersByCity/{city}")
	@ResponseBody
	public List<Customer> getCustomersByCity(@PathVariable String city) {
		return query.getCustomersByCity(city);
	}

	@GetMapping("/getCustomersByPostalCode/{postalCode}")
	@ResponseBody
	public List<Customer> getCustomersByPostalCode(@PathVariable String postalCode) {
		return query.getCustomersByPostalCode(postalCode);
	}
	
	@GetMapping("/getAllCustomers")
	@ResponseBody
	public List<Customer> getAllCustomers() {
		return query.getAllCustomers();
	}
	
	
	@GetMapping("/getInventoryForProduct/{productCode}")
	@ResponseBody
	public Integer getInventoryForProduct(@PathVariable String productCode) {
		return query.getInventoryForProduct(productCode);
	}

	
	@GetMapping("/getProductCodesForProductLines")
	@ResponseBody
	public List<String> getProductCodesForProductLines(@RequestBody List<String> productLines) {
		return query.getProductCodesForProductLines(productLines);		
	}

	@GetMapping("/getEmployees")
	@ResponseBody
	public List<Employee> getEmployees() {
		return query.getEmployees();
	}
	
	@GetMapping("/getEmployeeHierarchy")
	@ResponseBody
	public List<Employee> getEmployeeHierarchy() {
		return query.getEmployeeHierarchy();
	}

}
