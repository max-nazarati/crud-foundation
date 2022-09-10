package maxnazarati.web.pattern.crud.example;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class FakeUserRepository {

    private Map<Integer, User> users = new HashMap<>();
    private int idCounter = 0;

    public Optional<User> findByEmail(String email) {
        return users.values().stream().filter(u -> u.getEmail().equals(email)).findFirst();
    }

    public List<User> findAllById(List<Integer> integers) {
        return users.values().stream().filter(u -> integers.contains(u.getId())).toList();
    }

    public void delete(User entity) {
        users.remove(entity.getId());

    }

    public <S extends User> S save(S entity) {
        users.put(entity.getId(), entity);
        return entity;
    }

    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(users.get(id));
    }

}
