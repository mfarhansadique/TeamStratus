package stratus;

public class FlightsResults {
    private String dayOfFlight;
    private double priceOfFlight;
    private String classOfFlight;



    public String getDayOfFlight() {
        return dayOfFlight;
    }

    public void setDayOfFlight(String dayOfFlight) {
        this.dayOfFlight = dayOfFlight;
    }

    public double getPriceOfFlight() {
        return priceOfFlight;
    }

    public void setPriceOfFlight(double priceOfFlight) {
        this.priceOfFlight = priceOfFlight;
    }

    public String getClassOfFlight() {
        return classOfFlight;
    }

    public void setClassOfFlight(String classOfFlight) {
        this.classOfFlight = classOfFlight;
    }

    public String getStopOver() {
        return stopOver;
    }

    public void setStopOver(String stopOver) {
        this.stopOver = stopOver;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    private String stopOver;
    private String duration;
}
