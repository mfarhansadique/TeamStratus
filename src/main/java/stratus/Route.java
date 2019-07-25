package stratus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String routeDetails;
    private String startLocation;
    private String endLocation;
    private Date date;
    private boolean favourite;
    private char transportMethod;
    private String startLongitude;
    private String endLongitude;
    private String endLatitude;
    private String startLatitude;
    private String currency;
    private String locationName;

    @ManyToMany
    private List<User> users = new ArrayList<User>();

    public Route(String routeDetails, String startLocation, String endLocation, Date date, boolean favourite, char transportMethod, String startLongitude, String endLongitude, String endLatitude, String startLatitude, String currency, String locationName, List<User> users) {
        this.routeDetails = routeDetails;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.date = date;
        this.favourite = favourite;
        this.transportMethod = transportMethod;
        this.startLongitude = startLongitude;
        this.endLongitude = endLongitude;
        this.endLatitude = endLatitude;
        this.startLatitude = startLatitude;
        this.currency = currency;
        this.locationName = locationName;
        this.users = users;
    }

    public Route() {
    }

    ;

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

    public String getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(String startLongitude) {
        this.startLongitude = startLongitude;
    }

    public String getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(String endLongitude) {
        this.endLongitude = endLongitude;
    }

    public String getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(String endLatitude) {
        this.endLatitude = endLatitude;
    }

    public String getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(String startLatitude) {
        this.startLatitude = startLatitude;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
