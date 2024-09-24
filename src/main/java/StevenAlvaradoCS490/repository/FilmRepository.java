package StevenAlvaradoCS490.repository;

import StevenAlvaradoCS490.entity.Film;
import StevenAlvaradoCS490.dto.FilmDto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    
    @Query(value = "select f.title, count(r.rental_id) as rented " +
                   "from rental r " +
                   "join inventory i on i.inventory_id = r.inventory_id " +
                   "join film f on i.film_id = f.film_id " +
                   "group by f.film_id , f.title " + 
                   "order by rented desc " +
                   "limit 5", nativeQuery = true)
    
    List<FilmDto> findTop5RentedFilms();

    //fetch all details of film by id
    Optional<Film> findByID(Long id);
}
