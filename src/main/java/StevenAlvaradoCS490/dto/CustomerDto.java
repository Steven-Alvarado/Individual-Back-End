package StevenAlvaradoCS490.dto;

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
public class CustomerDto {

    private Integer customerId;
    private Integer storeId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer addressId;
    private List<RentalDto> rentals;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
}

