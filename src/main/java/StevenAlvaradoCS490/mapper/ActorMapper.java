package StevenAlvaradoCS490.mapper;

import StevenAlvaradoCS490.dto.ActorDto;
import StevenAlvaradoCS490.dto.FilmDto;
import StevenAlvaradoCS490.entity.Actor;
import StevenAlvaradoCS490.entity.Film;

import java.util.List;
import java.util.stream.Collectors;

public class ActorMapper {

    public static ActorDto mapToActorDto(Actor actor, List<Film> topRentedFilms) {
        // Map basic actor details
        ActorDto actorDto = new ActorDto(
                actor.getActorId(),
                actor.getFirstName(),
                actor.getLastName(),
                actor.getLastUpdate(),
                null
        );

        // Map top rented films to FilmDto list and set in ActorDto
        List<FilmDto> filmDtos = topRentedFilms.stream()
                .map(FilmMapper::mapToFilmDto)  // Assuming FilmMapper has a mapToFilmDto method
                .collect(Collectors.toList());
        actorDto.setTopRentedFilms(filmDtos);

        return actorDto;
    }
}