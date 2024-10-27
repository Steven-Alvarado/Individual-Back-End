package StevenAlvaradoCS490.service;

import StevenAlvaradoCS490.dto.ActorDto;
import StevenAlvaradoCS490.entity.Actor;
import StevenAlvaradoCS490.repository.ActorRepository;

import java.util.List;
import java.util.stream.Collectors;

public interface ActorService {

    public List<ActorDto> getTop5ActorsWithTopRentedFilms();
}
