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
@Table(name = "rental")
public class Rental{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rental_id;
    private LocalDateTime rental_date;
    private Long inventory_id;
    private Long customer_id;
    private LocalDateTime return_date;
    //private Long staff_id;
    private LocalDateTime last_update;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}



