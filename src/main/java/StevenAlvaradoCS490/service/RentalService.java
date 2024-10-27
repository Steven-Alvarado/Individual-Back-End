package StevenAlvaradoCS490.service;

import StevenAlvaradoCS490.dto.RentalRequestDto;
import StevenAlvaradoCS490.entity.Rental;

public interface RentalService {

    Rental rentMovieToCustomer(RentalRequestDto rentalRequest);
}
