package veterinary.exampets.mapper.converters;

import org.springframework.stereotype.Component;
import veterinary.exampets.mapper.GlobalMapper;
import veterinary.exampets.models.Pet;
import veterinary.exampets.models.PetsResponse;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class PetsResponseConverter extends GlobalMapper<Pet, PetsResponse> {
    UUID uuid = UUID.randomUUID();

    @Override
    public PetsResponse fromModelToDto(Pet model) {
        PetsResponse response = new PetsResponse();
        response.setName(model.getName());
        response.setStatus(model.getStatus());
        response.setTransactionId(uuid.toString());
        response.getDateCreated();

        return response;
    }

    @Override
    public Pet fromDtoToModel(PetsResponse model) {
        return null;
    }
}
