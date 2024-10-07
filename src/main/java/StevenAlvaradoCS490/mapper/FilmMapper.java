package StevenAlvaradoCS490.mapper;

import StevenAlvaradoCS490.dto.FilmDto;
import StevenAlvaradoCS490.dto.FilmCategoryDto;
import StevenAlvaradoCS490.dto.FilmActorDto;
import StevenAlvaradoCS490.mapper.*;
import StevenAlvaradoCS490.entity.*;
import java.util.List;
import java.util.stream.Collectors;

public class FilmMapper {

    // Mapping from Film entity to FilmDto
    public static FilmDto mapToFilmDto(Film film) {
        return new FilmDto(
                film.getFilmId(),
                film.getTitle(),
                FilmCategoryMapper.mapToFilmCategoryDtoList(film.getFilmCategories()),  // Updated to include category names
                film.getDescription(),
                film.getReleaseYear(),
                FilmActorMapper.mapToFilmActorDtoList(film.getFilmActors()),  // Updated to include actor names
                film.getLanguage() != null ? film.getLanguage().getLanguageId() : null,
                film.getOriginalLanguage() != null ? film.getOriginalLanguage().getLanguageId() : null,
                film.getRentalDuration(),
                film.getRentalRate(),
                film.getLength(),
                film.getReplacementCost(),
                film.getRating(),
                film.getSpecialFeatures(),
                film.getLastUpdate()
        );
    }

    // Mapping from FilmDto to Film entity
    public static Film mapToFilm(FilmDto filmDto, Language language, Language originalLanguage, List<FilmCategory> filmCategories, List<FilmActor> filmActors) {
        return new Film(
                filmDto.getFilmId(),
                filmDto.getTitle(),
                filmCategories,  // Now we're passing the fully constructed List<FilmCategory>
                filmDto.getDescription(),
                filmDto.getReleaseYear(),
                filmActors,  // Now we're passing the fully constructed List<FilmActor>
                language,
                originalLanguage,
                filmDto.getRentalDuration(),
                filmDto.getRentalRate(),
                filmDto.getLength(),
                filmDto.getReplacementCost(),
                filmDto.getRating(),
                filmDto.getSpecialFeatures(),
                filmDto.getLastUpdate()
        );
    }

    // Helper method to map List<FilmCategory> to List<FilmCategoryDto>
    private static List<FilmCategoryDto> mapToFilmCategoryDtoList(List<FilmCategory> filmCategories) {
        return filmCategories.stream()
                .map(FilmCategoryMapper::mapToFilmCategoryDto)
                .collect(Collectors.toList());
    }

    // Helper method to map List<FilmActor> to List<FilmActorDto>
    private static List<FilmActorDto> mapToFilmActorDtoList(List<FilmActor> filmActors) {
        return filmActors.stream()
                .map(FilmActorMapper::mapToFilmActorDto)
                .collect(Collectors.toList());
    }
}
