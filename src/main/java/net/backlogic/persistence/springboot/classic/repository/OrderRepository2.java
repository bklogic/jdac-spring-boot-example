package net.backlogic.persistence.springboot.classic.repository;

import net.backlogic.persistence.client.GenericRepository;
import net.backlogic.persistence.client.annotation.Read;
import net.backlogic.persistence.client.annotation.RepositoryService;
import net.backlogic.persistence.springboot.classic.model.Order;

@RepositoryService("/repository/Order")
public interface OrderRepository2 extends GenericRepository<Order> {
	
	@Read
	public Order getOrderById(int orderNumber);
	
}