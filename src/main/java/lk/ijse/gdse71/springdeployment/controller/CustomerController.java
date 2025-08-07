package lk.ijse.gdse71.springdeployment.controller;

import lk.ijse.gdse71.springdeployment.entity.Customer;
import lk.ijse.gdse71.springdeployment.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
/*@RequiredArgsConstructor*/
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.update(customer));
    }

    @DeleteMapping("/delete")
    public void deleteCustomer(@RequestParam Integer id) {
       customerService.delete(id);
    }
}
