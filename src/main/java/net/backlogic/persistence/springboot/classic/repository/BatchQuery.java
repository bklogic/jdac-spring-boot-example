package net.backlogic.persistence.springboot.classic.repository;

import java.util.List;

import net.backlogic.persistence.client.Batch;
import net.backlogic.persistence.client.annotation.BatchService;
import net.backlogic.persistence.client.annotation.ReturnMapping;
import net.backlogic.persistence.client.annotation.Query;
import net.backlogic.persistence.springboot.classic.model.BatchDTO;
import net.backlogic.persistence.springboot.classic.model.Customer;
import net.backlogic.persistence.springboot.classic.model.Employee;

@BatchService("")
public interface BatchQuery extends Batch<BatchDTO> {
	@Query("query/getCustomerByCustomerNumber")
	@ReturnMapping("customer")
	Customer getCustomer(int customerNumber);

	@Query("query/listEmployees")
	@ReturnMapping("employees")
	List<Employee> getEmployees();

}
