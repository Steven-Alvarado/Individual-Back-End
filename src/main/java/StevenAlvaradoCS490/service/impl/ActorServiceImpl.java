package StevenAlvaradoCS490.service.impl;

import StevenAlvaradoCS490.dto.ActorDto;
import StevenAlvaradoCS490.entity.Actor;
import StevenAlvaradoCS490.entity.Film;
import StevenAlvaradoCS490.mapper.ActorMapper;
import StevenAlvaradoCS490.mapper.FilmMapper;
import StevenAlvaradoCS490.repository.ActorRepository;
import StevenAlvaradoCS490.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {
    private ActorRepository actorRepository;


    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }


    @Override
    public List<ActorDto> getTop5ActorsWithTopRentedFilms() {
        // Retrieve the top 5 actors
        List<Actor> topActors = actorRepository.findTop5ActorsInRentedFilms();

        return topActors.stream().map(actor -> {
            // Fetch the top rented films for the current actor
            List<Film> topRentedFilms = actorRepository.findTop5RentedFilmsByActor(actor.getActorId());

            // Map Actor and top rented films to ActorDto
            ActorDto actorDto = ActorMapper.mapToActorDto(actor, topRentedFilms);

            return actorDto;
        }).collect(Collectors.toList());
    }

}
