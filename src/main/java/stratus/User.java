package stratus;

import org.hibernate.internal.util.type.PrimitiveWrapperHelper;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity @Table(name="user")
public class User {

    @Id @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String postCode;
    private String login;
    private String password;
    private String email;
    private String telephoneNumber;
    private char role;

    @ManyToMany
    private List<Route> routes; //make sure that user adds the routes to themselves

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public User(String firstName, String lastName, String address, String city, String postCode, String login, String password, String email, String telephoneNumber, char role, List<Route> routes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.login = login;
        this.password = password;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.role = role;
        this.routes = routes;
    }

    public User() {};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }
}
