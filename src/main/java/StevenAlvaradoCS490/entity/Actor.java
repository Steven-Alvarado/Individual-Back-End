package StevenAlvaradoCS490.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.Jointable;
import jakarta.persistence.JoinColumn;
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
@Table(name = "actor")
public class Actor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actor_id;
    private String first_name;
    private String last_name;
    private LocalDateTime last_update;

    @ManyToMany
    @JoinTable(
        name = "film_actor",
        joinColumns = @JoinColumn(name = "actor_id"),
        inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Film> films;
}


