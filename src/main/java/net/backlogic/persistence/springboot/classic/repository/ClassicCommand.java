package net.backlogic.persistence.springboot.classic.repository;

import net.backlogic.persistence.client.annotation.Command;
import net.backlogic.persistence.client.annotation.CommandService;
import net.backlogic.persistence.springboot.classic.model.DuplicateProductLineRequest;
import net.backlogic.persistence.springboot.classic.model.ProductLine;

@CommandService("/command")
public interface ClassicCommand {
	
	/*
	 * clone a source product line
	 */
	@Command("cloneProductLine")
	ProductLine duplicateProductLine(DuplicateProductLineRequest req);
	
	/*
	 * Remove customer, along with orders and payments
	 */
	@Command("deleteCustomer")
	void removeCustomer(Integer customerNumber);
	
}
