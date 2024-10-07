package StevenAlvaradoCS490.mapper;

import StevenAlvaradoCS490.dto.FilmCategoryDto;
import StevenAlvaradoCS490.entity.Category;
import StevenAlvaradoCS490.entity.Film;
import StevenAlvaradoCS490.entity.FilmCategory;

import java.util.List;
import java.util.stream.Collectors;

public class FilmCategoryMapper {

    // Map from FilmCategory entity to FilmCategoryDto
    public static FilmCategoryDto mapToFilmCategoryDto(FilmCategory filmCategory) {
        return new FilmCategoryDto(
                filmCategory.getFilm().getFilmId(),
                filmCategory.getCategory().getCategoryId(),
                filmCategory.getCategory().getName(),
                filmCategory.getLastUpdate()
        );
    }

    // Mapping a list of FilmCategory entities to a list of FilmCategoryDto
    public static List<FilmCategoryDto> mapToFilmCategoryDtoList(List<FilmCategory> filmCategories) {
        return filmCategories.stream()
                .map(FilmCategoryMapper::mapToFilmCategoryDto)  // Use the mapToFilmCategoryDto method
                .collect(Collectors.toList());
    }
}

