package net.backlogic.persistence.springboot.classic.repository;

import java.util.List;

import net.backlogic.persistence.client.Batch;
import net.backlogic.persistence.client.annotation.BatchService;
import net.backlogic.persistence.client.annotation.Query;
import net.backlogic.persistence.springboot.classic.model.Customer;
import net.backlogic.persistence.springboot.classic.model.Employee;

@BatchService("")
public interface BatchQuery extends Batch {
	
	@Query("query/getCustomerByCustomerNumber")
	public Customer getCustomer(int customerNumber);

	@Query("query/listEmployees")
	public List<Employee> getEmployees();
	
}
