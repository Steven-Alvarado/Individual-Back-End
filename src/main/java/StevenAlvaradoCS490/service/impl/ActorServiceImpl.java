package StevenAlvaradoCS490.service.impl;

import StevenAlvaradoCS490.dto.ActorDto;
import StevenAlvaradoCS490.entity.Actor;
import StevenAlvaradoCS490.mapper.ActorMapper;
import StevenAlvaradoCS490.repository.ActorRepository;
import StevenAlvaradoCS490.service.ActorService;

import java.util.List;
import java.util.stream.Collectors;

public class ActorServiceImpl implements ActorService {
    private ActorRepository actorRepository;

    @Override
    public List<ActorDto> getTop5Actors() {
        List<Actor> actors = actorRepository.findTop5ActorsInRentedFilms();
        return actors.stream()
                .map(ActorMapper::mapToActorDto)
                .collect(Collectors.toList());
    }
}
