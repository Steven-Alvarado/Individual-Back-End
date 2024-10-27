package StevenAlvaradoCS490.repository;

import StevenAlvaradoCS490.entity.City;
import StevenAlvaradoCS490.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    Optional<City> findByCityAndCountry(String cityName, Country country);
}

