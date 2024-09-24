package StevenAlvaradoCS490.entity;


import java.time.LocalDateTime;
import java.io.Serializable;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "film_actor")
@IdClass(FilmActor.FilmActorId.class)
public class FilmActor implements Serializable{

    @Id
    @Column(name = "actor_id")
    private Long actorId;

    @Id
    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class FilmActorId implements Serializable{
        @Column(name = "actor_id")
        private Long actorId;
        @Column(name = "film_id")
        private Long filmId;
    }
}



