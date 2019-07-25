package stratus.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stratus.User;
import stratus.UserDAO;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return UserDAO.getAllUsers();

    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    User newUser(@RequestBody User newUser) {
        userDAO.insertUser(newUser);
        return newUser;
    }


    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable int id) {
        try {
            User u = userDAO.getUserById(id);
            userDAO.deleteUser(u);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + "No such user with ID " + id);
        }

    }
}
