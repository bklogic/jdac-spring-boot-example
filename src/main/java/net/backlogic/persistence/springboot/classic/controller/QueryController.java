package net.backlogic.persistence.springboot.classic.controller;

import net.backlogic.persistence.springboot.classic.model.Customer;
import net.backlogic.persistence.springboot.classic.model.Employee;
import net.backlogic.persistence.springboot.classic.model.ProductLine;
import net.backlogic.persistence.springboot.classic.repository.ClassicQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("query")
public class QueryController {

	@Autowired
	private ClassicQuery query;

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

	@GetMapping("/getInventoryForProduct/{productCode}")
	@ResponseBody
	public Integer getInventoryForProduct(@PathVariable String productCode) {
		return query.getInventoryForProduct(productCode);
	};

	@GetMapping("/getCustomersByPostalCode/{postalCode}")
	@ResponseBody
	public List<Customer> getCustomersByPostalCode(@PathVariable String postalCode) {
		return query.getCustomersByPostalCode(postalCode);
	}

	@RequestMapping("/getProductLines")
	@ResponseBody
	public List<ProductLine> getProductLines() {
		return query.getProductLines();
	}
	
	@RequestMapping("/getEmployees")
	@ResponseBody
	public List<Employee> getEmployees() {
		return query.getEmployees();
	}

}
