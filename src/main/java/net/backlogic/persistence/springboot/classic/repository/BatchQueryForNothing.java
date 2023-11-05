package net.backlogic.persistence.springboot.classic.repository;

import net.backlogic.persistence.client.Batch;
import net.backlogic.persistence.client.annotation.BatchService;
import net.backlogic.persistence.client.annotation.Query;
import net.backlogic.persistence.client.annotation.ReturnMapping;
import net.backlogic.persistence.springboot.classic.model.BatchDTO;
import net.backlogic.persistence.springboot.classic.model.Customer;
import net.backlogic.persistence.springboot.classic.model.Employee;

import java.util.List;

@BatchService("")
public interface BatchQueryForNothing extends Batch<Void> {
	@Query("query/getCustomerByCustomerNumber")
	Customer getCustomer(int customerNumber);

	@Query("query/listEmployees")
	List<Employee> getEmployees();

}
