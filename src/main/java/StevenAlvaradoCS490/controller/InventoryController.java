package StevenAlvaradoCS490.controller;

import StevenAlvaradoCS490.dto.RentalAvailabilityDto;
import StevenAlvaradoCS490.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/availability/{filmId}")
    public ResponseEntity<RentalAvailabilityDto> checkRentalAvailability(@PathVariable Integer filmId) {
        RentalAvailabilityDto availability = inventoryService.checkRentalAvailability(filmId);
        return ResponseEntity.ok(availability);
    }
}
