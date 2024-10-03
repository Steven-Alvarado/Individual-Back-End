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

    //POST create film REST API
    @PostMapping
    public ResponseEntity<FilmDto> createFilm(@RequestBody FilmDto filmDto) {
        FilmDto savedFilm = filmService.createFilm(filmDto);
        return new ResponseEntity<>(savedFilm, HttpStatus.CREATED);
    }

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

    //PUT update film REST API
    @PutMapping("{film_id}")
    public ResponseEntity<FilmDto> updateFilm(@PathVariable("film_id") Integer filmId,
                                                      @RequestBody FilmDto updatedFilm) {
        FilmDto filmDto = filmService.updateFilm(filmId, updatedFilm);
        return ResponseEntity.ok(filmDto);
    }

    //DELETE film REST API
    @DeleteMapping("{film_id}")
    public ResponseEntity<String> deleteFilm(@PathVariable("film_id") Integer filmId) {
        filmService.deleteFilm(filmId);
        return ResponseEntity.ok("Film with ID: " + filmId + " deleted successfully");
    }
}

