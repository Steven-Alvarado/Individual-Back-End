package StevenAlvaradoCS490.repository;

import StevenAlvaradoCS490.entity.Address;
import StevenAlvaradoCS490.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findByAddressAndCity(String address, City city);
}
