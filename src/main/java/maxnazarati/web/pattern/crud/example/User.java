package maxnazarati.web.pattern.crud.example;

import maxnazarati.web.pattern.crud.foundation.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Model<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    private int someIntValue;

    public User() {

    }

    @Override
    public void updateBy(Model<Integer> other) {
        var otherUser = (User) other;
        email = otherUser.email;
        someIntValue = otherUser.someIntValue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSomeIntValue(int someIntValue) {
        this.someIntValue = someIntValue;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getSomeIntValue() {
        return someIntValue;
    }

}
