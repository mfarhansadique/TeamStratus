package stratus;


public class Journey {
    private String duration;
    private String departure;
    private int routes=1;
    private String departureCoordinates;
    private String destinationCoordinates;

    public Journey(String duration, String departure, String departureCoordinates, String destinationCoordinates) {
        this.duration = duration;
        this.departure = departure;
        this.departureCoordinates = departureCoordinates;
        this.destinationCoordinates = destinationCoordinates;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public int getRoutes() {
        return routes;
    }

    public void setRoutes(int routes) {
        this.routes = routes;
    }

    public String getDepartureCoordinates() {
        return departureCoordinates;
    }

    public void setDepartureCoordinates(String departureCoordinates) {
        this.departureCoordinates = departureCoordinates;
    }

    public String getDestinationCoordinates() {
        return destinationCoordinates;
    }

    public void setDestinationCoordinates(String destinationCoordinates) {
        this.destinationCoordinates = destinationCoordinates;
    }
}
