package StevenAlvaradoCS490.mapper;

import StevenAlvaradoCS490.dto.ActorDto;
import StevenAlvaradoCS490.entity.Actor;

public class ActorMapper {
    public static ActorDto mapToActorDto(Actor actor) {
        return new ActorDto(

                actor.getActorId(),
                actor.getFirstName(),
                actor.getLastName(),
                actor.getLastUpdate(),
                actor.getFilmActors()

        );
    }
}
