package veterinary.exampets.services;

import org.apache.coyote.BadRequestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import veterinary.exampets.client.PetsClient;

import veterinary.exampets.mapper.converters.PetsResponseConverter;
import veterinary.exampets.models.Pet;
import veterinary.exampets.models.PetsResponse;

@Service
public class PetService {
    PetsResponseConverter globalMapper;
    PetsClient petsClient;
    private static final Logger logger = LogManager.getLogger(PetService.class);


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
    public ResponseEntity<?> getPetId(int id) throws BadRequestException {
        // 1. Service-side Validation
        if (id <= 0) {
            throw new BadRequestException("Invalid Pet ID. ID must be greater than 0.");
        }

        ResponseEntity<Pet> responseEntity = petsClient.getIdPets(id);

        // 2. Client Response Validation
        if (responseEntity.getStatusCode().is4xxClientError()) {
            throw new BadRequestException("The external pets service rejected this request.");
        }

        return new ResponseEntity<>(responseEntity.getBody(), responseEntity.getStatusCode());
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
        logger.info("Pet Saved: created: {}, TranssactionId: {}, Name: {}", petsResponse.getDateCreated(), petsResponse.getTransactionId(), petsResponse.getName());
        return new ResponseEntity<>(petsResponse, responseEntity.getStatusCode());
    }


}
