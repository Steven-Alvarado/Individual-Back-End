package StevenAlvaradoCS490.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategoryDto {

    private Integer categoryId;
    private Integer filmId;
    private String categoryName;    // The ID of the Category
    private LocalDateTime lastUpdate;  // Last update time for the FilmCategory entry
}

