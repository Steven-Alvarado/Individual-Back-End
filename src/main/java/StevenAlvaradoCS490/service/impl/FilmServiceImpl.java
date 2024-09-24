package StevenAlvaradoCS490.service.impl;

import lombok.AllArgsConstructor;
import StevneAlvaradoCS490.FilmDto;
import StevneAlvaradoCS490.entity.Film;
import StevenAlvaradoCS490.service.FilmService;
import StevenAlvaradoCS490.repository.FilmRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import StevenAlvaradoCS490.exception.ResourceNotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService{

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private FilmMapper filmMapper;

    @Override
    public List<FilmDto> getTop5RentedFilms(){
        List<Film> topFilms = filmRepository.findTop5RentedFilms();
        return topFilms.stream().map(filmMapper::toDto).collect(Collectors.toList());
    }

    @Override 
    public Film getFilmById(Long id) {
        return filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Film not found"));
    }
}
