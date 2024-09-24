package StevenAlvaradoCS490.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FilmDto{

    private Long filmId;
    private String title;
    private String description;
    private String releaseYear;
    private Long languageId;
    private Long originalLanguageId;
    private Long rentalDuration;
    private BigDecimal rentalRate;
    private int length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    private LocalDateTime lastUpdate;

}
