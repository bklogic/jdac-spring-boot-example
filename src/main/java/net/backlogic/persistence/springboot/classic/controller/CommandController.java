package net.backlogic.persistence.springboot.classic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.backlogic.persistence.springboot.classic.model.DuplicateProductLineRequest;
import net.backlogic.persistence.springboot.classic.model.ProductLine;
import net.backlogic.persistence.springboot.classic.repository.ClassicCommand;

@RestController
@RequestMapping("command")
public class CommandController {
	
	@Autowired
	private ClassicCommand command;
	
	@PostMapping("/duplicateProductLine")
	public ProductLine duplicateProductLine(@RequestBody DuplicateProductLineRequest req) {
		return command.duplicateProductLine(req);
	}
	
	@PostMapping("/removeCustomer/{customerNumber}")
	public void removeCustomer(@PathVariable Integer customerNumber) {
		command.removeCustomer(customerNumber);
	}

}
