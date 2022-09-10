package maxnazarati.web.pattern.crud.example;

import maxnazarati.web.pattern.crud.foundation.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final CrudService<Integer, User, UserQuery> service;
    private final UserExtension extension;

    @Autowired
    public UserController(CrudService<Integer, User, UserQuery> service, UserExtension extension) {
        this.service = service;
        this.extension = extension;
    }

    @PostMapping
    public User create(@RequestBody User user) {
       return service.create(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return service.get(id);
    }

    @GetMapping("/email/{email}")
    public User getByEmail(@PathVariable String email) {
        return extension.getByEmail(email);
    }

}
