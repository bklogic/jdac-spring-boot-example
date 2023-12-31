package net.backlogic.persistence.springboot.classic.controller;

import net.backlogic.persistence.client.DataAccessClient;
import net.backlogic.persistence.springboot.classic.model.BatchDTO;
import net.backlogic.persistence.springboot.classic.model.Customer;
import net.backlogic.persistence.springboot.classic.model.Employee;
import net.backlogic.persistence.springboot.classic.model.Order;
import net.backlogic.persistence.springboot.classic.repository.BatchQuery;
import net.backlogic.persistence.springboot.classic.repository.BatchQueryForGenericArray;
import net.backlogic.persistence.springboot.classic.repository.BatchQueryForNothing;
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

    /**
     * Random batched Queries returning DTO
     * @param customerNumber
     * @return
     */
    @GetMapping("/batchedCustomerAndEmployees/{customerNumber}")
    @ResponseBody
    public BatchDTO batchedCustomerAndEmployees(@PathVariable int customerNumber) {
        BatchQuery batchQuery = client.getBatch(BatchQuery.class);
        batchQuery.getCustomer(customerNumber);
        batchQuery.getEmployees();
        BatchDTO dto = batchQuery.get();
        return dto;
    }

    /**
     * Random batched Queries returning generic array
     * @param customerNumber
     * @return
     */
    @GetMapping("/batchedCustomerAndEmployees2/{customerNumber}")
    @ResponseBody
    public BatchDTO batchedCustomerAndEmployees2(@PathVariable int customerNumber) {
        BatchQueryForGenericArray batchQuery = client.getBatch(BatchQueryForGenericArray.class);
        batchQuery.getCustomer(customerNumber);
        batchQuery.getEmployees();
        Object[] results = batchQuery.get();
        BatchDTO dto = new BatchDTO();
        dto.setCustomer((Customer) results[0]);
        dto.setEmployees((List<Employee>) results[1]);
        return dto;
    }

    /**
     * Random batched Queries returning VOID
     * @param customerNumber
     * @return
     */
    @GetMapping("/batchedCustomerAndEmployees3/{customerNumber}")
    @ResponseBody
    public BatchDTO batchedCustomerAndEmployees3(@PathVariable int customerNumber) {
        BatchQueryForNothing batchQuery = client.getBatch(BatchQueryForNothing.class);
        batchQuery.getCustomer(customerNumber);
        batchQuery.getEmployees();
        Object result = batchQuery.get();
        BatchDTO dto = (BatchDTO) result;
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
