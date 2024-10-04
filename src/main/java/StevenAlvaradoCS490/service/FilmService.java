package StevenAlvaradoCS490.service;

import StevenAlvaradoCS490.dto.FilmDto;
import StevenAlvaradoCS490.entity.Film;

import java.util.List;

public interface FilmService {


    FilmDto getFilmById(Integer id);

    List<FilmDto> getAllFilms();
    
}

