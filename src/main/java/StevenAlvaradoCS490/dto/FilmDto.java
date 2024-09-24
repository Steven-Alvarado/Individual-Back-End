package StevenAlvaradoCS490.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FilmDto{
    
    private Long film_id; 
    private String title;
    private String description;
    private String release_year;
    private Long language_id;
    private Long original_language_id;
    private Long rental_duration;
    private BigDecimal rental_rate;
    private int length;
    private BigDecimal replacement_cost;
    private String rating;
    private String special_features;
    private LocalDateTime last_update;

}
