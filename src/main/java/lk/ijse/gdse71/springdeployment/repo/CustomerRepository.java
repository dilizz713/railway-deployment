package lk.ijse.gdse71.springdeployment.repo;

import lk.ijse.gdse71.springdeployment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
