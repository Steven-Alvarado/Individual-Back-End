package StevenAlvaradoCS490.service.impl;

import StevenAlvaradoCS490.dto.FilmActorDto;
import StevenAlvaradoCS490.dto.FilmCategoryDto;
import StevenAlvaradoCS490.dto.FilmDto;
import StevenAlvaradoCS490.entity.*;
import StevenAlvaradoCS490.exception.ResourceNotFoundException;
import StevenAlvaradoCS490.mapper.FilmMapper;
import StevenAlvaradoCS490.repository.ActorRepository;
import StevenAlvaradoCS490.repository.CategoryRepository;
import StevenAlvaradoCS490.repository.FilmRepository;
import StevenAlvaradoCS490.repository.LanguageRepository;
import StevenAlvaradoCS490.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final CategoryRepository categoryRepository;
    private final ActorRepository actorRepository;
    private final LanguageRepository languageRepository;

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
    public Film mapToEntity(FilmDto filmDto) {
        // Fetch Language and Original Language
        Language language = languageRepository.findById(filmDto.getLanguageId())
                .orElseThrow(() -> new ResourceNotFoundException("Language not found"));
        Language originalLanguage = filmDto.getOriginalLanguageId() != null
                ? languageRepository.findById(filmDto.getOriginalLanguageId())
                .orElseThrow(() -> new ResourceNotFoundException("Original Language not found"))
                : null;

        // Fetch Film Categories and Actors in the service
        List<FilmCategory> filmCategories = filmCategoryDtosToEntities(filmDto.getFilmCategories());
        List<FilmActor> filmActors = filmActorDtosToEntities(filmDto.getFilmActors());

        // Return the mapped Film entity
        return FilmMapper.mapToFilm(filmDto, language, originalLanguage, filmCategories, filmActors);
    }

    private List<FilmCategory> filmCategoryDtosToEntities(List<FilmCategoryDto> filmCategoryDtos) {
        return filmCategoryDtos.stream()
                .map(filmCategoryDto -> {
                    Film film = filmRepository.findById(filmCategoryDto.getFilmId())
                            .orElseThrow(() -> new RuntimeException("Film not found"));
                    Category category = categoryRepository.findById(filmCategoryDto.getCategoryId())
                            .orElseThrow(() -> new RuntimeException("Category not found"));

                    return new FilmCategory(new FilmCategoryId(film.getFilmId(), category.getCategoryId()), film, category, filmCategoryDto.getLastUpdate());
                })
                .collect(Collectors.toList());
    }

    private List<FilmActor> filmActorDtosToEntities(List<FilmActorDto> filmActorDtos) {
        return filmActorDtos.stream()
                .map(filmActorDto -> {
                    Film film = filmRepository.findById(filmActorDto.getFilmId())
                            .orElseThrow(() -> new RuntimeException("Film not found"));
                    Actor actor = actorRepository.findById(filmActorDto.getActorId())
                            .orElseThrow(() -> new RuntimeException("Actor not found"));

                    return new FilmActor(new FilmActorId(film.getFilmId(), actor.getActorId()), film, actor, filmActorDto.getLastUpdate());
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<FilmDto> getTop5RentedFilms() {
        List<Film> films = filmRepository.findTop5RentedFilms();
        return films.stream()
                .map(FilmMapper::mapToFilmDto)
                .collect(Collectors.toList());
    }

}


