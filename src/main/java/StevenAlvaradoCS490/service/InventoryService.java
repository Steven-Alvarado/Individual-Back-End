package StevenAlvaradoCS490.service;

import StevenAlvaradoCS490.dto.RentalAvailabilityDto;

public interface InventoryService {
        RentalAvailabilityDto checkRentalAvailability(Integer filmId);
}
