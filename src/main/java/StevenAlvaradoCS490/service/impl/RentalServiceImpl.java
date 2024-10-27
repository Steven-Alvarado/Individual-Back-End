package StevenAlvaradoCS490.service.impl;

import StevenAlvaradoCS490.dto.RentalRequestDto;
import StevenAlvaradoCS490.entity.Customer;
import StevenAlvaradoCS490.entity.Inventory;
import StevenAlvaradoCS490.entity.Rental;
import StevenAlvaradoCS490.entity.Staff;
import StevenAlvaradoCS490.repository.CustomerRepository;
import StevenAlvaradoCS490.repository.InventoryRepository;
import StevenAlvaradoCS490.repository.RentalRepository;
import StevenAlvaradoCS490.repository.StaffRepository;
import StevenAlvaradoCS490.service.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final CustomerRepository customerRepository;
    private final InventoryRepository inventoryRepository;
    private final RentalRepository rentalRepository;
    private final StaffRepository staffRepository;

    @Override
    public Rental rentMovieToCustomer(RentalRequestDto rentalRequest) {
        // Fetch customer by ID
        Customer customer = customerRepository.findById(rentalRequest.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Get a list of available inventory items for the film
        List<Inventory> availableInventory = inventoryRepository.findAvailableInventoryByFilmId(rentalRequest.getFilmId());

        if (availableInventory.isEmpty()) {
            throw new RuntimeException("No available inventory for this film");
        }

        // Select the first available inventory item
        Inventory inventory = availableInventory.get(0);


        // Fetch the staff member
        Staff staff = staffRepository.findById(rentalRequest.getStaffId())
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        // Create and save the rental
        Rental rental = new Rental();
        rental.setCustomer(customer);
        rental.setInventory(inventory);
        rental.setStaff(staff);
        rental.setRentalDate(LocalDateTime.now());
        rental.setLastUpdate(LocalDateTime.now());

        return rentalRepository.save(rental);
    }

    @Override
    public Rental returnFilm(Integer rentalId) {
        // Find the rental by ID
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental not found with ID: " + rentalId));

        // Update the return date
        rental.setReturnDate(LocalDateTime.now());
        rental.setLastUpdate(LocalDateTime.now()); // Update last update timestamp

        // Save and return the updated rental
        return rentalRepository.save(rental);
    }
}
