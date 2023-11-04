package net.backlogic.persistence.springboot.classic.controller;

import net.backlogic.persistence.springboot.classic.model.BatchQueryResult;
import net.backlogic.persistence.springboot.classic.model.Customer;
import net.backlogic.persistence.springboot.classic.model.Employee;
import net.backlogic.persistence.springboot.classic.model.Order;
import net.backlogic.persistence.springboot.classic.repository.BatchQuery;
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
    private BatchQuery batchQuery;
    @Autowired
    private BatchRepository batchRepository;

    @GetMapping("/batchedCustomerAndEmployees/{customerNumber}")
    @ResponseBody
    public BatchQueryResult batchedCustomerAndEmployees(@PathVariable int customerNumber) {
        batchQuery.getCustomer(customerNumber);
        batchQuery.getEmployees();
        Object[] results = batchQuery.get();
        BatchQueryResult queryResult = new BatchQueryResult();
        queryResult.setCustomer((Customer) results[0]);
        queryResult.setEmployees((List<Employee>) results[1]);
        return queryResult;
    }

    @PostMapping("batchRepository")
    public Map<String, Object> batchRepository(@RequestBody Order order) {
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
