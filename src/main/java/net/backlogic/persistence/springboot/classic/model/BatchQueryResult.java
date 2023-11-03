package net.backlogic.persistence.springboot.classic.model;

import java.util.List;

public class BatchQueryResult {
    private Customer customer;
    private List<Employee> employees;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
