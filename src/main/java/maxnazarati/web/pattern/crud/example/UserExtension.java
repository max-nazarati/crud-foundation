package maxnazarati.web.pattern.crud.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExtension {
    private final UserPersistenceHandler persistenceHandler;

    @Autowired
    public UserExtension(UserPersistenceHandler persistenceHandler) {
        this.persistenceHandler = persistenceHandler;
    }

    public User getByEmail(String email) {
        return persistenceHandler.retrieveByEmail(email).orElseThrow(() -> new RuntimeException(String.format("A User with email [%s] does not exist!", email)));
    }

}
