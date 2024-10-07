package StevenAlvaradoCS490.dto;
import StevenAlvaradoCS490.entity.Customer;
import StevenAlvaradoCS490.entity.Inventory;
import StevenAlvaradoCS490.entity.Staff;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Year;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RentalDto {
    private Integer rentalId;
    private LocalDateTime rentalDate;
    private Integer inventoryId;
    private Integer customerId;
    private LocalDateTime returnDate;
    private Integer staffId;
    private LocalDateTime lastUpdate;
}
