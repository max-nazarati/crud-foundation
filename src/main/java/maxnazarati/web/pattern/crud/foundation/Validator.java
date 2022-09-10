package maxnazarati.web.pattern.crud.foundation;

public interface Validator<M> {
    public void validateCreationOrUpdate(M model);
    public void validateDeletion(M model);

}
