package veterinary.exampets.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import veterinary.exampets.client.PetsClient;
import veterinary.exampets.mapper.GlobalMapper;
import veterinary.exampets.mapper.converters.PetsResponseConverter;
import veterinary.exampets.models.Pet;
import veterinary.exampets.models.PetsResponse;

@Service
public class PetService {
    PetsResponseConverter globalMapper;
    PetsClient petsClient;


    public PetService(PetsResponseConverter globalMapper, PetsClient petsClient) {
        this.globalMapper = globalMapper;
        this.petsClient = petsClient;
    }

    /**
     * GetPetClient
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> getPetId(int id) {
        ResponseEntity<Pet> responseEntity = petsClient.getIdPets(id);
        return new ResponseEntity<>(responseEntity.getBody()  , responseEntity.getStatusCode());
    }

    /**
     * GetPetClient
     *
     * @param pet
     * @return
     */
    public ResponseEntity<?> postPet(Pet pet) {
        ResponseEntity<Pet> responseEntity = petsClient.savePet(pet);
        PetsResponse petsResponse = globalMapper.fromModelToDto(responseEntity.getBody());
        System.out.println("values: created: "+petsResponse.getDateCreated()+", TranssactionId:" +petsResponse.getTransactionId()+", Name:" +petsResponse.getName());
        return new ResponseEntity<>(petsResponse, responseEntity.getStatusCode());
    }


}
