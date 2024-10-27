package StevenAlvaradoCS490.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Embeddable
@Table(name = "film_actor")

public class FilmActor {

    @EmbeddedId
    private FilmActorId id;

    @ManyToOne
    @MapsId("filmId")  // Maps the film_id from the composite key
    @JoinColumn(name = "film_id")
    @JsonIgnore
    private Film film;

    @ManyToOne
    @MapsId("actorId")  // Maps the actor_id from the composite key
    @JoinColumn(name = "actor_id")
    @JsonIgnore
    private Actor actor;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    // Constructor to match the one used in the mapper
    public FilmActor(Film film, Actor actor, LocalDateTime lastUpdate) {
        this.film = film;
        this.actor = actor;
        this.id = new FilmActorId(film.getFilmId(), actor.getActorId());
        this.lastUpdate = lastUpdate;
    }
}

