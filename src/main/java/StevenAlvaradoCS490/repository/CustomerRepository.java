package StevenAlvaradoCS490.repository;

import StevenAlvaradoCS490.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
