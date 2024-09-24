package StevenAlvaradoCS490.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

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
@Table(name = "customer")
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "address_id")
    private Long addressId;
    private char active;
    @Column(name = "create_date")
    private LocalDate createDate;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;



    @OneToMany(mappedBy = "customer")
    private List<Rental> rentals;
}



