package veterinary.exampets.controller;


import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veterinary.exampets.models.Pet;
import veterinary.exampets.services.PetService;

@RestController
@RequestMapping("/api/pet")
public class PetsController {
    PetService petService;

    public PetsController(PetService petService) {
        this.petService = petService;
    }


    @GetMapping("/{idpet}")
    public ResponseEntity<?> findById(@PathVariable int idpet) throws BadRequestException {
        ResponseEntity<?> response = petService.getPetId(idpet);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @PostMapping
    public ResponseEntity<?> findById(@Valid @RequestBody Pet pet) throws BadRequestException {
        ResponseEntity<?> response = petService.postPet(pet);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }
}
