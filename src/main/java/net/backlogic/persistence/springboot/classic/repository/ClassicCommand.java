package net.backlogic.persistence.springboot.classic.repository;

import net.backlogic.persistence.client.annotation.BacklogicCommand;
import net.backlogic.persistence.client.annotation.Name;

@BacklogicCommand("/command")
public interface ClassicCommand {
	
	/*
	 * clone a source product line
	 */
	@Name("duplicateProductLine")
	void duplicateProductLine(String sourceProductLine, String targetProductLine);
	
	/*
	 * Remove customer, along with orders and payments
	 */
	@Name("removeCustomer")
	void removeCustomer(Integer customerNumber);
}
