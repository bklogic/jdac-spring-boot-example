package net.backlogic.persistence.springboot.classic.repository;

import java.util.List;

import net.backlogic.persistence.client.Batch;
import net.backlogic.persistence.client.annotation.BatchService;
import net.backlogic.persistence.client.annotation.Read;
import net.backlogic.persistence.client.annotation.Save;
import net.backlogic.persistence.springboot.classic.model.Order;

@BatchService
public interface BatchRepository extends Batch {
	
	@Save("repository/Order")
	List<Order> saveOrders(List<Order> orders);
	
	@Save("repository/Order")
	Order saveOrder(Order order);
	
	@Read("repository/Order")
	List<Order> getOrdersByCustomer(Integer customerNumber);
		
}
