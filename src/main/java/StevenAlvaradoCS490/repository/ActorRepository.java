package StevenAlvaradoCS490.repository;

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
                "ORDER BY COUNT(r) DESC")
        List<Actor> findTop5ActorsInRentedFilms();

}

