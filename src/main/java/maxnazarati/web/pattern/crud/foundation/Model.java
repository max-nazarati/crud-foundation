package maxnazarati.web.pattern.crud.foundation;

public interface Model<ID> {
    ID id();
    void updateBy(Model<ID> other);
}
