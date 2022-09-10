package maxnazarati.web.pattern.crud.example;

import maxnazarati.web.pattern.crud.foundation.PersistenceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserPersistenceHandler implements PersistenceHandler<Integer, User, UserQuery> {
    private final FakeUserRepository repository;

    @Autowired
    public UserPersistenceHandler(FakeUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User model) {
        return repository.save(model);
    }

    @Override
    public Optional<User> retrieve(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<User> list(UserQuery query) {
        return repository.findAllById(query.ids()).stream().toList();
    }

    @Override
    public void delete(User model) {
        repository.delete(model);
    }
    
    public Optional<User> retrieveByEmail(String email) {
        return repository.findByEmail(email);
    }

}
