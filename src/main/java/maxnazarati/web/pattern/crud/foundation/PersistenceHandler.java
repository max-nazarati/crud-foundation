package maxnazarati.web.pattern.crud.foundation;

import java.util.List;

public interface PersistenceHandler<ID, M extends Model<ID>, Q extends Query<ID>> {
    M save(M model);
    M retrieve(ID id);
    List<M> list(Q query);
    void delete(M model);

}
