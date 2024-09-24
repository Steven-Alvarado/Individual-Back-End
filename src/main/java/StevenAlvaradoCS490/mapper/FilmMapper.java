package StevenAlvaradoCS490.mapper;

import StevenAlvaradoCS490.dto.FilmDto;
import StevenAlvaradoCS490.entity.Film;

public class FilmMapper{

    public FilmDto mapToFilmDto(Film film){
        return new FilmDto(
            film.getFilmId(),
            film.getTitle(),
            film.getDescription(),
            film.getReleaseYear(),
            film.getLanguageId(),
            film.getOriginalLanguageId(),
            film.getRentalDuration(),
            film.getRentalRate(),
            film.getLength(),
            film.getReplacementCost(),
            film.getRating(),
            film.getSpecialFeatures(),
            film.getLastUpdate()
        );
    }

    public static Film mapToFilm(FilmDto filmDto){
        return new Film(
            filmDto.getFilmId(),
            filmDto.getTitle(),
            filmDto.getDescription(),
            filmDto.getReleaseYear(),
            filmDto.getLanguageId(),
            filmDto.getOriginalLanguageId(),
            filmDto.getRentalDuration(),
            filmDto.getRentalRate(),
            filmDto.getLength(),
            filmDto.getReplacementCost(),
            filmDto.getRating(),
            filmDto.getSpecialFeatures(),
            filmDto.getLastUpdate()
        );
    }
}
