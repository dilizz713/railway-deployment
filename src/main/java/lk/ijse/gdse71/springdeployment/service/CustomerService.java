package lk.ijse.gdse71.springdeployment.service;

import lk.ijse.gdse71.springdeployment.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);

    List<Customer> getAll();

    Customer update(Customer customer);

    void delete(Integer id);
}
