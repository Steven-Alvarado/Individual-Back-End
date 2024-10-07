package StevenAlvaradoCS490.entity;
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
@Table(name = "film_category")

public class FilmCategory {

    @EmbeddedId
    private FilmCategoryId id;

    @ManyToOne
    @MapsId("filmId")  // Maps the film_id from the composite key
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @MapsId("categoryId")  // Maps the category_id from the composite key
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    // Constructor to match the one used in the mapper
    public FilmCategory(Film film, Category category, LocalDateTime lastUpdate) {
        this.film = film;
        this.category = category;
        this.id = new FilmCategoryId(film.getFilmId(), category.getCategoryId());
        this.lastUpdate = lastUpdate;
    }
}

