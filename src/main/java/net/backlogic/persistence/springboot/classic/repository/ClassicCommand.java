package net.backlogic.persistence.springboot.classic.repository;

import net.backlogic.persistence.client.annotation.Command;
import net.backlogic.persistence.client.annotation.CommandService;
import net.backlogic.persistence.springboot.classic.model.ProductLine;

@CommandService("/command")
public interface ClassicCommand {
	
	/*
	 * clone a source product line
	 */
	@Command("duplicateProductLine")
	ProductLine duplicateProductLine(String sourceProductLine, String targetProductLine);
	
	/*
	 * Remove customer, along with orders and payments
	 */
	@Command("removeCustomer")
	void removeCustomer(Integer customerNumber);
}
