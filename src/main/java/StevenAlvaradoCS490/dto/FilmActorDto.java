package StevenAlvaradoCS490.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmActorDto {
    private Integer filmId;
    private Integer actorId;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;  // Last update time for the FilmCategory entry
}