package stratus;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity @Table(name="route")
public class Route {

    @Id @GeneratedValue
private int id;
private String routeDetails;
private String startLocation;
private String endLocation;
private Date date;
private boolean favourite;
private char transportMethod;

    @ManyToMany
private List<User> users;

    public Route(int id, String routeDetails, String startLocation, String endLocation, Date date, boolean favourite, char transportMethod, List<User> users) {
        this.id = id;
        this.routeDetails = routeDetails;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.date = date;
        this.favourite = favourite;
        this.transportMethod = transportMethod;
        this.users = users;
    }

    public Route(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRouteDetails() {
        return routeDetails;
    }

    public void setRouteDetails(String routeDetails) {
        this.routeDetails = routeDetails;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public char getTransportMethod() {
        return transportMethod;
    }

    public void setTransportMethod(char transportMethod) {
        this.transportMethod = transportMethod;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
