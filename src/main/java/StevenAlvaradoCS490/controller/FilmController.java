package StevenAlvaradoCS490.controller;

import StevenAlvaradoCS490.dto.FilmDto;
import StevenAlvaradoCS490.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/films")
public class FilmController {

    private FilmService filmService;

    //GET film REST API
    @GetMapping("{film_id}")
    public ResponseEntity<FilmDto> getFilmById(@PathVariable("film_id") Integer filmId) {
        FilmDto filmDto = filmService.getFilmById(filmId);
        return ResponseEntity.ok(filmDto);
    }

    //GET all films REST API
    @GetMapping
    public ResponseEntity<List<FilmDto>> getAllFilms() {
        List<FilmDto>   films = filmService.getAllFilms();
        return ResponseEntity.ok(films);
    }

    //GET top 5 movies
    @GetMapping("/top5")
    public ResponseEntity<List<FilmDto>> getTop5RentedFilms() {
        List<FilmDto> topFilms = filmService.getTop5RentedFilms();
        return ResponseEntity.ok(topFilms);
    }

}

