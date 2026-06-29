package veterinary.exampets.mapper;

public abstract class GlobalMapper<M, D> {

    /**
     * convert from model to dto
     * @param model
     * @return
     */
    public abstract D fromModelToDto(M model);

    /**
     * convert from dto to model
     * @param dto
     * @return
     */
    public abstract M fromDtoToModel(D dto);
}
