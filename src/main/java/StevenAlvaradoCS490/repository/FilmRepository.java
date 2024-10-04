package StevenAlvaradoCS490.repository;

import StevenAlvaradoCS490.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}

