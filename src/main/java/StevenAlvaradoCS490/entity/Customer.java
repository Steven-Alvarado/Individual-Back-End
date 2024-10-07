package StevenAlvaradoCS490.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "customer_id")
        private Integer customerId;

        @ManyToOne
        @JoinColumn(name = "store_id")
        private Store store;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        private String email;

        @ManyToOne
        @JoinColumn(name= "address_id")
        private Address address;

        @OneToMany(mappedBy= "customer")
        private List<Rental> rentals;

        @Column(name = "create_date")
        private LocalDateTime createDate;

        @Column(name = "last_update")
        private LocalDateTime lastUpdate;

}
