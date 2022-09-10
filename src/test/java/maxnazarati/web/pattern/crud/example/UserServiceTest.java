package maxnazarati.web.pattern.crud.example;

import maxnazarati.web.pattern.crud.foundation.CrudServiceTest;

class UserServiceTest extends CrudServiceTest<Integer, User, UserQuery> {

    public UserServiceTest() {
        super(new UserService(new UserValidator(), new UserPersistenceHandler(new FakeUserRepository())));
    }

    @Override
    protected User getModel() {
        var user = new User();
        user.setId(1);
        user.setEmail("email");
        user.setSomeIntValue(4);
        return user;
    }

    @Override
    protected User getExpectedModel() {
        var user = new User();
        user.setId(1);
        user.setEmail("email");
        user.setSomeIntValue(4);
        return user;
    }

}