package StevenAlvaradoCS490.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
        @Column(name = "store_id", nullable = false)
        private Short storeId;
        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        private String email;
        @Column(name = "address_id", nullable = false)
        private Integer addressId;
        private Short active;
        @Column(name = "create_date")
        private LocalDateTime createDate;
        @Column(name = "last_update")
        private LocalDateTime lastUpdate;

}
