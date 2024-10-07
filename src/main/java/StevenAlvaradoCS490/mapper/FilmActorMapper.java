package StevenAlvaradoCS490.mapper;

import StevenAlvaradoCS490.dto.FilmActorDto;
import StevenAlvaradoCS490.entity.Actor;
import StevenAlvaradoCS490.entity.Film;
import StevenAlvaradoCS490.entity.FilmActor;

import java.util.List;
import java.util.stream.Collectors;

public class FilmActorMapper {
    // Map from FilmActor entity to FilmActorDto
    public static FilmActorDto mapToFilmActorDto(FilmActor filmActor) {
        return new FilmActorDto(
                filmActor.getFilm().getFilmId(),
                filmActor.getActor().getActorId(),
                filmActor.getActor().getFirstName(),
                filmActor.getActor().getLastName(),
                filmActor.getLastUpdate()
        );
    }

    // Mapping a list of FilmActor entities to a list of FilmActorDto
    public static List<FilmActorDto> mapToFilmActorDtoList(List<FilmActor> filmActors) {
        return filmActors.stream()
                .map(FilmActorMapper::mapToFilmActorDto)  // Use the mapToFilmActorDto method
                .collect(Collectors.toList());
    }
}
