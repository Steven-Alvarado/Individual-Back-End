package StevenAlvaradoCS490.controller;

import StevenAlvaradoCS490.dto.ActorDto;
import StevenAlvaradoCS490.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/actors")
public class ActorController {

    private ActorService actorService;
/*
    //GET actor REST API
    @GetMapping("{actor_id}")
    public ResponseEntity<ActorDto> getActorById(@PathVariable("actor_id") Integer actorId) {
        ActorDto actorDto = actorService.getActorById(actorId);
        return ResponseEntity.ok(actorDto);
    }

    //GET all actors REST API
    @GetMapping
    public ResponseEntity<List<ActorDto>> getAllActors() {
        List<ActorDto>   actors = actorService.getAllActors();
        return ResponseEntity.ok(actors);
    }
*/
    //GET top 5 movies
    @GetMapping("/top5")
    public ResponseEntity<List<ActorDto>> getTop5RentedActors() {
        List<ActorDto> topActors = actorService.getTop5ActorsWithTopRentedFilms();
        return ResponseEntity.ok(topActors);
    }

}

