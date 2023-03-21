package net.backlogic.persistence.springboot.classic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.backlogic.persistence.client.DataAccessClient;
import net.backlogic.persistence.springboot.classic.model.Order;
import net.backlogic.persistence.springboot.classic.repository.BatchRepository;
import net.backlogic.persistence.springboot.classic.repository.OrderRepository;
import net.backlogic.persistence.springboot.classic.repository.OrderRepository2;

@RestController
@RequestMapping("/repository/order")
public class OrderController {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private OrderRepository2 repository2;
	
	@Autowired
	private DataAccessClient client;
	
	@PostMapping("createOrder")
	public Order createOrder(@RequestBody Order order) {
		return repository2.create(order);
	}
	
	@PostMapping("getOrderById/{orderNumber}")
	public Order getOrderById(@PathVariable Integer orderNumber) {
		List<Order> orders = repository.getOrderById(orderNumber);
		if (orders.size() > 0) {
			return orders.get(0);
		} else {
			return null;
		}
	}	
	
	@PostMapping("getOrderById2/{orderNumber}")
	public Order getOrderById2(@PathVariable Integer orderNumber) {
		return repository2.getOrderById(orderNumber);
	}	
	
	@PostMapping("deleteOrder/{orderNumber}")
	public void deleteOrder(@PathVariable long orderNumber) {
		Order order = new Order();
		order.setOrderNumber(orderNumber);
		repository2.delete(order);
	}	
	
	@PostMapping("batch")
	public Map<String, Object> batch(@RequestBody Order order) {
		// run batch
		List<Order> orders = new ArrayList<>();
		BatchRepository batchRepository = (BatchRepository) this.client.getBatch(BatchRepository.class);
		batchRepository.saveOrder(order);
		batchRepository.getOrdersByCustomer(order.getCustomerNumber());
		Object[] output = batchRepository.run();
		
		// process result
		Map<String, Object> result = new HashMap<>();
		result.put("savedOrders", output[0]);
		result.put("customerOrders", output[1]);
		
		return result;
	}
	
}
