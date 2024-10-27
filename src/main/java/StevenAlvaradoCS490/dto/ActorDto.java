package StevenAlvaradoCS490.dto;

import StevenAlvaradoCS490.entity.FilmActor;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActorDto {

    private Integer actorId;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;
    private List<FilmDto> topRentedFilms;
}
