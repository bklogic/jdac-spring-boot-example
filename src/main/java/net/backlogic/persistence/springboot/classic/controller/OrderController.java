package net.backlogic.persistence.springboot.classic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	
	@GetMapping("getOrderById/{orderNumber}")
	public Order getOrderById(@PathVariable Integer orderNumber) {
		return repository.getOrderById(orderNumber);
	}	
	
	@GetMapping("getOrderById2/{orderNumber}")
	public Order getOrderById2(@PathVariable Integer orderNumber) {
		return repository2.getOrderById(orderNumber);
	}	
	
	@DeleteMapping("deleteOrder/{orderNumber}")
	public void deleteOrder(@PathVariable long orderNumber) {
		Order order = new Order();
		order.setOrderNumber(orderNumber);
		repository2.delete(order);
	}	
	
	
	@PutMapping("saveOrders")
	public List<Order> saveOrders(@RequestBody List<Order> orders) {
		return repository.save(orders);
	}

	
	@PostMapping("batch")
	public Map<String, Object> batch(@RequestBody Order order) {
		// run batch
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		BatchRepository batchRepository = this.client.getBatch(BatchRepository.class);
		batchRepository.saveOrders(orders);
		batchRepository.getOrdersByCustomer(order.getCustomerNumber());
		Object[] output = batchRepository.run();
		
		// process result
		Map<String, Object> result = new HashMap<>();
		result.put("savedOrders", output[0]);
		result.put("customerOrders", output[1]);
		
		return result;
	}

}
