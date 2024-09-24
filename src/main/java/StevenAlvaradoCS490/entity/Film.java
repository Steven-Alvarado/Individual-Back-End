package StevenAlvaradoCS490.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmId;

    private String title;
    private String description;

    @Column(name = "release_year")
    private String releaseYear;

    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "original_language_id")
    private Long originalLanguageId;

    @Column(name = "rental_duration")
    private Long rentalDuration;

    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    private int length;
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;

    private String rating;

    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    // Relationships
    @ManyToMany(mappedBy = "films")
    private List<Actor> actors;

    @ManyToMany
    @JoinTable(
        name = "film_category",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @OneToMany(mappedBy = "film")
    private List<Inventory> inventories;

    public Film(Long filmId, String title, String description, String releaseYear, Long languageId, Long originalLanguageId, Long rentalDuration, BigDecimal rentalRate, int length, BigDecimal replacementCost, String rating, String specialFeatures, LocalDateTime lastUpdate) {
    }
}
