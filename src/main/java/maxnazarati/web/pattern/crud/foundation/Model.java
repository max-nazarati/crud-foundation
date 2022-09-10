package maxnazarati.web.pattern.crud.foundation;

public interface Model<ID> {
    ID getId();
    void updateBy(Model<ID> other);
}
