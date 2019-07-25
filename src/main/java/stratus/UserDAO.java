package stratus;

import java.util.List;

public interface UserDAO {
    public List<String> findAll();
    public boolean save(User member);
    public User findByLogin(String login);
}
