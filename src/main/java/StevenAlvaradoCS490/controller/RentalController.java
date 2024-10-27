package StevenAlvaradoCS490.controller;

import StevenAlvaradoCS490.dto.RentalRequestDto;
import StevenAlvaradoCS490.entity.Rental;
import StevenAlvaradoCS490.service.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("api/rentals")
public class RentalController {

    private final RentalService rentalService;

    @PostMapping("/rent")
    public ResponseEntity<Rental> rentMovieToCustomer( @RequestBody RentalRequestDto rentalRequest) {
        Rental rental = rentalService.rentMovieToCustomer(rentalRequest);
        return ResponseEntity.ok(rental);
    }
}
