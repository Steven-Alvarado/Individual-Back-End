package StevenAlvaradoCS490.repository;

import StevenAlvaradoCS490.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    List<Rental> findByCustomerCustomerId(Integer customerId);

}
