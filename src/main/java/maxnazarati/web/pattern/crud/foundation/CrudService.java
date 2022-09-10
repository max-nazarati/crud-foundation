package maxnazarati.web.pattern.crud.foundation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
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
        return persistenceHandler.retrieve(id).orElseThrow(() -> new RuntimeException(String.format("User with id [%s] was not found", id)));
    }

    public List<M> list(@Valid Q query) {
       return persistenceHandler.list(query);
    }

    public M update(@Valid M incomingModel, ID id) {
        validator.validateCreationOrUpdate(incomingModel);
        M existingModel = get(id);
        existingModel.updateBy(incomingModel);

        return persistenceHandler.save(existingModel);
    }
}
