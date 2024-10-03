package StevenAlvaradoCS490.service.impl;

import StevenAlvaradoCS490.dto.FilmDto;
import StevenAlvaradoCS490.entity.Film;
import StevenAlvaradoCS490.exception.ResourceNotFoundException;
import StevenAlvaradoCS490.mapper.FilmMapper;
import StevenAlvaradoCS490.repository.FilmRepository;
import StevenAlvaradoCS490.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {
    private FilmRepository filmRepository;

    @Override
    public FilmDto createFilm(FilmDto filmDto) {
        Film film = FilmMapper.mapToFilm(filmDto);
        Film savedFilm = filmRepository.save(film);
        return FilmMapper.mapToFilmDto(savedFilm);
    }

    @Override
    public FilmDto getFilmById(Integer filmId) {
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new ResourceNotFoundException("Film not found for ID: " + filmId));

        return FilmMapper.mapToFilmDto(film);
    }

    @Override
    public List<FilmDto> getAllFilms() {
        List<Film> films = filmRepository.findAll();
        return films.stream().map((film) -> FilmMapper.mapToFilmDto(film))
                .collect(Collectors.toList());
    }

    @Override
    public FilmDto updateFilm(Integer filmId, FilmDto updatedFilm) {
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new ResourceNotFoundException("Film not found for ID: " + filmId)
        );
        // TODO
        film.setFirstName(updatedFilm.getFirstName());
        film.setLastName(updatedFilm.getLastName());
        film.setEmail(updatedFilm.getEmail());
        film.setActive(updatedFilm.getActive());
        film.setAddressId(updatedFilm.getAddressId());
        film.setLastUpdate(updatedFilm.getLastUpdate());

        Film updatedFilmObj = filmRepository.save(film);
        return FilmMapper.mapToFilmDto(updatedFilmObj);
    }


    @Override
    public void deleteFilm(Integer filmId) {
        Film film = filmRepository.findById(filmId).orElseThrow(
                () -> new ResourceNotFoundException("Film not found for ID: " + filmId)
        );

        filmRepository.deleteById(filmId);
    }
}

