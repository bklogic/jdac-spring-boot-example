package net.backlogic.persistence.springboot.classic.controller;

import net.backlogic.persistence.client.DataAccessClient;
import net.backlogic.persistence.springboot.classic.model.BatchDTO;
import net.backlogic.persistence.springboot.classic.model.Customer;
import net.backlogic.persistence.springboot.classic.model.Employee;
import net.backlogic.persistence.springboot.classic.model.Order;
import net.backlogic.persistence.springboot.classic.repository.BatchQuery;
import net.backlogic.persistence.springboot.classic.repository.BatchQueryForGenericArray;
import net.backlogic.persistence.springboot.classic.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Place to test batched query and CRUD
 */

@RestController
@RequestMapping("batch")
public class BatchController {
    @Autowired
    DataAccessClient client;

    @GetMapping("/batchedCustomerAndEmployees/{customerNumber}")
    @ResponseBody
    public BatchDTO batchedCustomerAndEmployees(@PathVariable int customerNumber) {
        BatchQuery batchQuery = client.getBatch(BatchQuery.class);
        batchQuery.getCustomer(customerNumber);
        batchQuery.getEmployees();
        BatchDTO dto = batchQuery.get();
        return dto;
    }

    @GetMapping("/batchedCustomerAndEmployees2/{customerNumber}")
    @ResponseBody
    public BatchDTO batchedCustomerAndEmployees2(@PathVariable int customerNumber) {
        BatchQueryForGenericArray batchQuery = client.getBatch(BatchQueryForGenericArray.class);
        batchQuery.getCustomer(customerNumber);
        batchQuery.getEmployees();
        Object[] arr = batchQuery.get();
        BatchDTO dto = new BatchDTO();
        dto.setCustomer((Customer) arr[0]);
        dto.setEmployees((List<Employee>) arr[1]);
        return dto;
    }

    @PostMapping("batchRepository")
    public Map<String, Object> batchRepository(@RequestBody Order order) {
        BatchRepository batchRepository = client.getBatch(BatchRepository.class);
        // run batch
        List<Order> orders = new ArrayList<>();
        orders.add(order);
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
