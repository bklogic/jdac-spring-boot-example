package net.backlogic.persistence.springboot.classic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.backlogic.persistence.client.DataAccessClient;
import net.backlogic.persistence.springboot.classic.model.Customer;
import net.backlogic.persistence.springboot.classic.model.Employee;
import net.backlogic.persistence.springboot.classic.repository.BatchQuery;
import net.backlogic.persistence.springboot.classic.repository.ClassicQuery;


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

	
	@PostMapping("/getProductCodesForProductLines")
	public List<String> getProductCodesForProductLines(@RequestBody List<String> productLines) {
		return query.getProductCodesForProductLines(productLines);		
	}

	@RequestMapping("/getEmployees")
	@ResponseBody
	public List<Employee> getEmployees() {
		return query.getEmployees();
	}
	
	@RequestMapping("/getEmployeeHierarchy")
	@ResponseBody
	public List<Employee> getEmployeeHierarchy() {
		return query.getEmployeeHierarchy();
	}

	@RequestMapping("/batchQuery/{customerNumber}")
	@ResponseBody
	public Object[] batchQuery(@PathVariable int customerNumber) {
		BatchQuery batch = (BatchQuery) this.client.getBatch(BatchQuery.class);
		batch.getCustomer(customerNumber);
		batch.getEmployees();
		return batch.get();
	}
	
}
