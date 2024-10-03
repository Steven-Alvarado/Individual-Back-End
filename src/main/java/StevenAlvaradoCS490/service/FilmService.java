package StevenAlvaradoCS490.service;

import StevenAlvaradoCS490.dto.FilmDto;
import StevenAlvaradoCS490.entity.Film;

import java.util.List;

public interface FilmService {
    FilmDto createFilm(FilmDto filmDto);

    FilmDto getFilmById(Integer id);

    List<FilmDto> getAllFilms();

    FilmDto updateFilm(Integer filmId, FilmDto updatedFilm);

    void deleteFilm(Integer filmId;
}

