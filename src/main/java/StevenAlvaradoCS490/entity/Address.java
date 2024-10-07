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
@Table(name = "address")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;

    private String address;

    @Column(name = "address2",nullable = true)
    private String address2;

    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "postal_code", nullable = true)
    private String postalCode;

    private String phone;

    // location might cause problems due to geometry data type excluding

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}