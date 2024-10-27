package StevenAlvaradoCS490.repository;

import StevenAlvaradoCS490.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import StevenAlvaradoCS490.entity.Actor;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {


        // top 5 actors
        @Query("SELECT a FROM Actor a " +
                "JOIN FilmActor fa ON a.actorId = fa.actor.actorId " +
                "JOIN Rental r ON fa.film.filmId = r.inventory.film.filmId " +
                "GROUP BY a.actorId " +
                "ORDER BY COUNT(r) DESC " +
                "LIMIT 5")
        List<Actor> findTop5ActorsInRentedFilms();

        // Get top 5 rented films for a specific actor
        @Query("SELECT f FROM Film f " +
                "JOIN FilmActor fa ON f.filmId = fa.film.filmId " +
                "JOIN Inventory i ON f.filmId = i.film.filmId " +
                "JOIN Rental r ON i.inventoryId = r.inventory.inventoryId " +
                "WHERE fa.actor.actorId = :actorId " +
                "GROUP BY f.filmId " +
                "ORDER BY COUNT(r) DESC " +
                "LIMIT 5")
        List<Film> findTop5RentedFilmsByActor(Integer actorId);

}

