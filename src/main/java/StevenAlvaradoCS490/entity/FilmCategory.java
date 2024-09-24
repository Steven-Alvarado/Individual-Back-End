package StevenAlvaradoCS490.entity;


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
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "film_category")
@IdClass(FilmCategoryId.class)
public class FilmActor implements Serializable{

    @Id
    private Long film_id;

    @Id
    private Long category_id;

    private LocalDateTime last_update;    

    // TODO: Create composite key class
}
