package stratus;

import org.json.JSONObject;

import java.util.Scanner;

public class WeatherAPI {


    private static Scanner scn;

    private static String apiKey = "fa7769554emshaab499374a3ea4dp179e68jsne2fbed25ad4d";
    private static String host = "dark-sky.p.rapidapi.com";
    private static String host2 = "airport-info.p.rapidapi.com";
    private static HttpApiResponse apiCaller = new HttpApiResponse(apiKey,host);
    private static HttpApiResponse apiCaller2 = new HttpApiResponse(apiKey,host2);

    private static String getWeatherByLatLon(String lat, String lon){
        return apiCaller.getRapidApiResponse("https://dark-sky.p.rapidapi.com/"+ lat +","+ lon +"?lang=en&units=auto");

    }

    private static String getWeatherByAirportCode(String airportCode){
        double lat;
        double lon;
        JSONObject toGet = new JSONObject(apiCaller2.getRapidApiResponse("https://airport-info.p.rapidapi.com/airport?iata="+airportCode));
        lat = toGet.getDouble("latitude");
        lon = toGet.getDouble("longitude");
        getWeatherByLatLon(Double.toString(lat),Double.toString(lon));
        return getWeatherByLatLon(Double.toString(lat),Double.toString(lon));
    }


    public static void main(String[] args) {
        scn = new Scanner(System.in);
        System.out.println(getWeatherByAirportCode("LHR"));

    }
}
