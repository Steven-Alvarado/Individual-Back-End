package StevenAlvaradoCS490.dto;

import StevenAlvaradoCS490.entity.FilmActor;
import StevenAlvaradoCS490.entity.FilmCategory;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Year;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {

    private Integer filmId;
    private String title;
    private List<FilmCategoryDto> filmCategories;
    private String description;
    private Year releaseYear;
    private List<FilmActorDto> filmActors;
    private Integer LanguageId;
    private Integer OriginalLanguageId;
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Short length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    private LocalDateTime lastUpdate;
    }



