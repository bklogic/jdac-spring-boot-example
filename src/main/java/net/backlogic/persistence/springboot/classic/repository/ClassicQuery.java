package net.backlogic.persistence.springboot.classic.repository;

import java.util.List;

import net.backlogic.persistence.client.annotation.Query;
import net.backlogic.persistence.client.annotation.QueryService;
import net.backlogic.persistence.springboot.classic.model.Customer;
import net.backlogic.persistence.springboot.classic.model.Employee;

@QueryService("/query")
public interface ClassicQuery {
	/*
	 * Get customer
	 */
	@Query("getCustomerByCustomerNumber")
	public Customer getCustomer(int customerNumber);

	@Query("getCustomersByCityOrPostalCode")
	public List<Customer> getCustomersByCity(String city);

	@Query("getCustomersByCityOrPostalCode")
	public List<Customer> getCustomersByPostalCode(String postalCode);

	@Query("getCustomersByCityOrPostalCode")
	public List<Customer> getAllCustomers();

	@Query("getInventoryForProduct")
	public Integer getInventoryForProduct(String productCode);

	@Query("getProductCodesForProductLines")
	public List<String> getProductCodesForProductLines(List<String> productLines);

	/*
	 * get all employees, along with their office, manager, and customers they are responsible for.
	 */
	@Query("listEmployees")
	public List<Employee> getEmployees();

	@Query("getEmployeeHierarchy")
	public List<Employee> getEmployeeHierarchy();
	
}
