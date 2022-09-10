package maxnazarati.web.pattern.crud.example;

import maxnazarati.web.pattern.crud.foundation.CrudService;
import maxnazarati.web.pattern.crud.foundation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudService<Integer, User, UserQuery> {

    @Autowired
    protected UserService(Validator<User> validator, UserPersistenceHandler userPersistenceHandler) {
        super(validator, userPersistenceHandler);
    }

}
