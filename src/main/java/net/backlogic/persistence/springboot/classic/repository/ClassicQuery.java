package net.backlogic.persistence.springboot.classic.repository;

import java.util.List;

import net.backlogic.persistence.client.annotation.BacklogicQuery;
import net.backlogic.persistence.client.annotation.Name;
import net.backlogic.persistence.springboot.classic.model.Customer;
import net.backlogic.persistence.springboot.classic.model.Employee;
import net.backlogic.persistence.springboot.classic.model.ProductLine;

@BacklogicQuery("/query")
public interface ClassicQuery {
	/*
	 * Get product lines along with products.
	 */
	@Name("getProductLines")
	public List<ProductLine> getProductLines();
	
	/*
	 * Get customer along with orders and payments info.
	 */
	@Name("getCustomer")
	public Customer getCustomer(int customerNumber);
		
	/*
	 * get all employees, along with their office, manager, and customers they are responsible for.
	 */
	@Name("getEmployees")
	public List<Employee> getEmployees();
}
