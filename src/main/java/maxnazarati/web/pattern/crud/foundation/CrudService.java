package maxnazarati.web.pattern.crud.foundation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public abstract class CrudService<ID, M extends Model<ID>, Q extends Query<ID>> {
    protected final Validator<M> validator;
    protected final PersistenceHandler<ID, M, Q> persistenceHandler;

    @Autowired
    protected CrudService(Validator<M> validator, PersistenceHandler<ID, M, Q> persistenceHandler) {
        this.validator = validator;
        this.persistenceHandler = persistenceHandler;
    }

    public M create(@Valid M model) {
        validator.validateCreationOrUpdate(model);
        return persistenceHandler.save(model);
    }

    public M get(ID id) {
        return persistenceHandler.retrieve(id);
    }

    public List<M> list(Q query) {
       return persistenceHandler.list(query);
    }

    public M update(M incomingModel, ID id) {
        validator.validateCreationOrUpdate(incomingModel);
        M existingModel = persistenceHandler.retrieve(id);
        existingModel.updateBy(incomingModel);

        return persistenceHandler.save(existingModel);
    }
}
