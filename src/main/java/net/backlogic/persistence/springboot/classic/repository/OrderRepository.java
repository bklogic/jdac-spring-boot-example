package net.backlogic.persistence.springboot.classic.repository;

import java.util.List;

import net.backlogic.persistence.client.annotation.BacklogicRepository;
import net.backlogic.persistence.client.annotation.Create;
import net.backlogic.persistence.client.annotation.Delete;
import net.backlogic.persistence.client.annotation.Read;
import net.backlogic.persistence.client.annotation.Save;
import net.backlogic.persistence.client.annotation.Update;
import net.backlogic.persistence.springboot.classic.model.Order;

@BacklogicRepository("/repositories/order")
public interface OrderRepository {
	
	@Create
	Order create(Order order);
	
	@Update
	Order update(Order order);
	
	@Delete
	void delete(Order order);
	
	@Save
	List<Order> save(List<Order> orders);
	
	@Read
	public Order getOrderById(Integer orderNumber);
	
	@Read
	public List<Order> getOrdersByCustomer(Integer customerNumber);
	
}
