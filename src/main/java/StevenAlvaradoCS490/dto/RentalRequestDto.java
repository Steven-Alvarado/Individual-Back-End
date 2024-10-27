package StevenAlvaradoCS490.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RentalRequestDto {
    private Integer customerId;
    private Integer filmId;
    private Integer staffId;
}
