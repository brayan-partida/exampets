package veterinary.exampets.mapper;

public abstract class GlobalMapper<M, D> {

    public abstract D fromModelToDto(M model);

    public abstract M fromDtoToModel(D dto);
}
