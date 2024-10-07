package StevenAlvaradoCS490.entity;

import java.math.BigDecimal;
import java.time.Year;
import jakarta.persistence.*;
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
@Entity
@Table(name = "film")
public class Film {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "film_id", nullable = false)
        private Integer filmId;

        private String title;

        @OneToMany(mappedBy = "film")
        private List<FilmCategory> filmCategories;

        private String description;

        @Column(name = "release_year")
        private Year releaseYear;

        @OneToMany(mappedBy= "film")
        private List<FilmActor> filmActors;

        @ManyToOne
        @JoinColumn(name = "language_id")
        private Language language;

        @ManyToOne
        @JoinColumn(name ="original_language_id", referencedColumnName = "language_id", nullable = true)
        private Language originalLanguage;

        @Column(name = "rental_duration")
        private Short rentalDuration;

        @Column(name = "rental_rate")
        private BigDecimal rentalRate;

        private Short length;

        @Column(name = "replacement_cost")
        private BigDecimal replacementCost;

        private String rating;

        @Column(name = "special_features")
        private String specialFeatures;

        @Column(name = "last_update")
        private LocalDateTime lastUpdate;

}

