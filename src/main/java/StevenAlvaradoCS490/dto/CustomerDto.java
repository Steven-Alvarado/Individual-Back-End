package StevenAlvaradoCS490.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Integer customerId;
    private Short storeId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer addressId;
    private Short active;
    private LocalDateTime creatDate;
    private LocalDateTime lastUpdate;
}

