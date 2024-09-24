package StevenAlvaradoCS490.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FILM")
public class Film{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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