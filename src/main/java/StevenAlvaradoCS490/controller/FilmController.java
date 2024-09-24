package StevenAlvaradoCS490.controller;

import lombok.AllArgsConstructor;
import StevenAlvaradoCS490.service.FilmService;
import StevenAlvaradoCS490.entity.Film;
import StevenAlvaradoCS490.dto.FilmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    // REST API's
    // enpoint to fetch top 5 most rented films
    @GetMapping("/top5films")
    public ResponseEntity<List<FilmDto>> getTop5RentedFilms() {
        List<FilmDto> topfilms = filmService.getTop5RentedFilms();
        return ResponseEntity.ok(topfilms);
    }

    // endpoint to fetch fill film details by ID
    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmDetails(@PathVariable Long id) {
        Film film = filmService.getFilmById(id);
        return ResponseEntity.ok(film);
    }
}
