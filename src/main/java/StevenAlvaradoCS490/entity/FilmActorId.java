package StevenAlvaradoCS490.entity;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmActorId implements Serializable {

    private Integer filmId;
    private Integer actorId;

}
