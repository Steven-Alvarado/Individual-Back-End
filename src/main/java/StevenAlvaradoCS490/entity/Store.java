package StevenAlvaradoCS490.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store")
public class Store {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Integer storeId;

    @ManyToOne
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id")
    private Staff manager;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

}
