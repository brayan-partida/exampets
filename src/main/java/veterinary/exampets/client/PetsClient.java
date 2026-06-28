package veterinary.exampets.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import veterinary.exampets.models.Pet;

@FeignClient(name = "pet", url = "${veterinary.service.pets}")
public interface PetsClient {

    @GetMapping("/{id}")
    ResponseEntity<Pet> getIdPets(@PathVariable int id);

    @PostMapping
    ResponseEntity<Pet> savePet(@RequestBody Pet pet);
}
