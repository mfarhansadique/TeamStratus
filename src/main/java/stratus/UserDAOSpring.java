package stratus;

import org.springframework.beans.factory.annotation.Autowired;
import stratus.data.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserDAOSpring implements UserDAO {
    @Autowired
    private UserRepository userRepository;

    public List<String> findAll() {
        ArrayList<String> allUsers = new ArrayList<String>();
        for (User u : userRepository.findAll()) {
            allUsers.add(u.getFirstName());}
        return allUsers;
    }

    public boolean save(User user) {
        userRepository.save(user);
        return true;
    }

    public User findByLogin(String login) {
        return null;
    };
}


