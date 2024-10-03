package StevenAlvaradoCS490.entity;

import java.math.BigDecimal;
import java.time.Year;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
import java.time.LocalDateTime;

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
        private String description;

        @Column(name = "release_year")
        private Year releaseYear;

        @Column(name = "language_id", nullable = false)
        private Short languageId;

        @Column(name = "original_language_id")
        private Short originalLanguageId;

        @Column(name = "rental_duration", nullable = false)
        private Short rentalDuration;

        @Column(name = "rental_rate", nullable = false)
        private BigDecimal rentalRate;

        private Short length;

        @Column(name = "replacement_cost", nullable = false)
        private BigDecimal replacementCost;

        private String rating;
        
        @Column(name = "special_feaures")
        private Set<String>  specialFeatures;

        @Column(name = "last_update")
        private LocalDateTime lastUpdate;

}

