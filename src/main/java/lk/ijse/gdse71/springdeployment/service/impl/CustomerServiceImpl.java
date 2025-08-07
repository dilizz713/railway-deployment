package lk.ijse.gdse71.springdeployment.service.impl;

import lk.ijse.gdse71.springdeployment.entity.Customer;
import lk.ijse.gdse71.springdeployment.repo.CustomerRepository;
import lk.ijse.gdse71.springdeployment.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*@RequiredArgsConstructor*/
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
       return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Customer customer) {
        Customer existsCustomer = customerRepository.findById(customer.getId()).orElseThrow(() -> new RuntimeException("Customer not found"));
        existsCustomer.setName(customer.getName());
        existsCustomer.setAddress(customer.getAddress());

        return customerRepository.save(existsCustomer);
    }

    @Override
    public void delete(Integer id) {
      Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
      customerRepository.delete(existingCustomer);
    }
}
