package StevenAlvaradoCS90.service;

import StevenAlvaradoCS490.entity.Film;
import StevenAlvaradoCS490.dto.FilmDto;

import java.util.List;

public interface FilmService{
    //Methods for feature get top 5 most rented films
    List<FilmDto> getTop5RentedFilms();
    // All details of film 
    Film getFilmById(Long id);

}
