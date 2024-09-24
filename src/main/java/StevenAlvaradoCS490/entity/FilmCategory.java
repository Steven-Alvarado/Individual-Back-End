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
@Table(name = "film_category")
@IdClass(FilmCategory.FilmCategoryId.class)
public class FilmCategory implements Serializable{

    @Id
    @Column(name = "film_id")
    private Long filmId;

    @Id
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class FilmCategoryId implements Serializable{

        @Column(name = "film_id")
        private Long filmId;

        @Column(name = "category_id")
        private Long categoryId;
    }
}
