package StevenAlvaradoCS490.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Year;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {

    private Integer filmId;
    private String title;
    private String description;
    private Year releaseYear;
    private Short languageId;
    private Short originalLanguageId ;
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Short length;
    private BigDecimal replacementCost; //FIX! in entity it is rental cost should be replacement
    private String rating;
    private Set<String> specialFeatures;
    private LocalDateTime lastUpdate;

}


