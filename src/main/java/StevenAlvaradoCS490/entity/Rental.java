package StevenAlvaradoCS490.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
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

    @Column(name = "rental_id")
    private Long rentalId;


    @Column(name = "rental_date")
    private LocalDateTime rentalDate;

    @Column(name = "inventory_id")
    private Long inventoryId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "return_date")
    private LocalDateTime returnDate;
    //private Long staff_id;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}



