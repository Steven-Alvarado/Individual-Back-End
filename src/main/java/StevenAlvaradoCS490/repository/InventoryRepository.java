package StevenAlvaradoCS490.repository;

import StevenAlvaradoCS490.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    // Count available inventory for a film
    @Query("SELECT COUNT(i) FROM Inventory i " +
            "WHERE i.film.filmId = :filmId AND i NOT IN " +
            "(SELECT r.inventory FROM Rental r WHERE r.returnDate IS NULL)")
    Long countAvailableInventoryByFilmId(Integer filmId);

    // Count rented inventory for a film (items not yet returned)
    @Query("SELECT COUNT(r) FROM Rental r " +
            "WHERE r.inventory.film.filmId = :filmId AND r.returnDate IS NULL")
    Long countRentedInventoryByFilmId(Integer filmId);

    @Query("SELECT i FROM Inventory i WHERE i.film.filmId = :filmId AND i NOT IN " +
            "(SELECT r.inventory FROM Rental r WHERE r.returnDate IS NULL)")
    List<Inventory> findAvailableInventoryByFilmId(Integer filmId);
}