package StevenAlvaradoCS490.dto;

import lombok.Data;

@Data
public class RentalAvailabilityDto {
    private Integer filmId;
    private Long availableCount;
    private Long rentedCount;

    public RentalAvailabilityDto(Integer filmId, Long availableCount, Long rentedCount) {
        this.filmId = filmId;
        this.availableCount = availableCount;
        this.rentedCount = rentedCount;
    }
}
