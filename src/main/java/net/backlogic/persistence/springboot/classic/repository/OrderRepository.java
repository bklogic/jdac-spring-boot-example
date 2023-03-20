package net.backlogic.persistence.springboot.classic.repository;

import net.backlogic.persistence.client.annotation.*;
import net.backlogic.persistence.springboot.classic.model.Order;

import java.util.List;

@RepositoryService("/repository/Order")
public interface OrderRepository {
	
	@Create
	Order create(Order order);
	
	@Update
	Order update(Order order);
	
	@Delete
	void delete(Order order);
	
	@Delete
	void delete(Integer orderNumber);
	
	@Save
	List<Order> save(List<Order> orders);
	
	@Read
	public List<Order> getOrderById(Integer orderNumber);
	
	@Read
	public List<Order> getOrdersByCustomer(Integer customerNumber);
	
}
