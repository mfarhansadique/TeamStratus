package stratus;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity @Table(name="admin")
public class Admin {

    @Id @GeneratedValue
    private int id;

    @OneToMany
    private List<User> users;

    public Admin(int id, List<User> users) {
        this.id = id;
        this.users = users;
    }

    public Admin(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
