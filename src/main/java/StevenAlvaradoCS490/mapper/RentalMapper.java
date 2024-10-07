package StevenAlvaradoCS490.mapper;

import StevenAlvaradoCS490.dto.RentalDto;
import StevenAlvaradoCS490.entity.Customer;
import StevenAlvaradoCS490.entity.Inventory;
import StevenAlvaradoCS490.entity.Rental;
import StevenAlvaradoCS490.entity.Staff;

public class RentalMapper {

    // Mapping from Rental entity to RentalDto
    public static RentalDto mapToRentalDto(Rental rental) {
        return new RentalDto(
                rental.getRentalId(),
                rental.getRentalDate(),
                rental.getInventory() != null ? rental.getInventory().getInventoryId() : null,  // Inventory ID
                rental.getCustomer() != null ? rental.getCustomer().getCustomerId() : null,  // Customer ID
                rental.getReturnDate(),
                rental.getStaff() != null ? rental.getStaff().getStaffId() : null,  // Staff ID
                rental.getLastUpdate()
        );
    }

    // Mapping from RentalDto to Rental entity
    public static Rental mapToRental(RentalDto rentalDto, Inventory inventory, Customer customer, Staff staff) {
        return new Rental(
                rentalDto.getRentalId(),
                rentalDto.getRentalDate(),
                inventory,  // Inventory entity
                customer,  // Customer entity
                rentalDto.getReturnDate(),
                staff,  // Staff entity
                rentalDto.getLastUpdate()
        );
    }
}
