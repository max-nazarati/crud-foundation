package maxnazarati.web.pattern.crud.example;

import maxnazarati.web.pattern.crud.foundation.Validator;
import org.springframework.stereotype.Component;

@Component
public class UserValidator implements Validator<User> {

    @Override
    public void validateCreationOrUpdate(User model) {

    }

    @Override
    public void validateDeletion(User model) {

    }

}
