package StevenAlvaradoCS490.repository;

import StevenAlvaradoCS490.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
