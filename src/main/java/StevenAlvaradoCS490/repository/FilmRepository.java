package StevenAlvaradoCS490.repository;

import StevenAlvaradoCS490.entity.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {

        //top 5 films
        @Query("SELECT f FROM Film f " +
                "JOIN Rental r ON f.filmId = r.inventory.film.filmId " +
                "GROUP BY f.filmId " +
                "ORDER BY COUNT(r) DESC " +
                "LIMIT 5 ")
        List<Film> findTop5RentedFilms();

}

