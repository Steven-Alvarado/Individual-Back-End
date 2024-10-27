package StevenAlvaradoCS490.service.impl;

import StevenAlvaradoCS490.dto.RentalAvailabilityDto;
import StevenAlvaradoCS490.repository.InventoryRepository;
import StevenAlvaradoCS490.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;


    public RentalAvailabilityDto checkRentalAvailability(Integer filmId) {
        Long availableCount = inventoryRepository.countAvailableInventoryByFilmId(filmId);
        Long rentedCount = inventoryRepository.countRentedInventoryByFilmId(filmId);

        return new RentalAvailabilityDto(filmId, availableCount, rentedCount);
    }
}
