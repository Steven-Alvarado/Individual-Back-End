package StevenAlvaradoCS490.repository;

import StevenAlvaradoCS490.entity.Country;
import StevenAlvaradoCS490.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CountryRepository extends JpaRepository<Country, Integer> {
    Optional<Country> findByCountry(String country);
}
