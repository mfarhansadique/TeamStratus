package stratus.web;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stratus.API.AirportInformation;
import stratus.API.HttpApiResponse;
import stratus.API.AmadeusFlightsApi;
import stratus.API.WeatherAPI;
import stratus.DAO.Route;
import stratus.DAO.RouteDAO;


import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

@Autowired
RouteDAO route;


 @GetMapping("/getairportcode/{location}")
 @ResponseBody
    public String getAirportCode(@PathVariable("location") String location){
     HttpApiResponse apires = new HttpApiResponse("fa7769554emshaab499374a3ea4dp179e68jsne2fbed25ad4d","skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
     List<String> airportCodes = AirportInformation.printLocationData(apires,location);
     String json = new Gson().toJson(airportCodes);
     System.out.println(json);
     return json;
 }

 //ignore

 @GetMapping("/getflight/{destinationcode}/{arrivalcode}/{destinationdate}")
 @ResponseBody
 public String getFlight(@PathVariable("destinationcode") String destinationcode, @PathVariable("arrivalcode") String arrivalcode, @PathVariable("destinationdate") String destinationdate){
  ArrayList flights = AmadeusFlightsApi.getFlightInfo(arrivalcode,destinationcode,destinationdate);
  String destinationWeather = WeatherAPI.getWeatherByAirportCode(destinationcode);
  String arrivalWeather = WeatherAPI.getWeatherByAirportCode(arrivalcode);
  String createWeatherJson = "{\"destinationWeather\":"+destinationWeather + ",\"arrivalWeather\":"+arrivalWeather+"}";
  String json = flights.get(0).toString();
  /*public Route(String routeDetails, String startLocation, String endLocation, String date, boolean favourite,
     char transportMethod, String startLongitude, String startLatitude, String endLongitude, String endLatitude,
             String currency, String locationName, List<User> user) {*/
  //route.save(new Route(json,flights.get(3),flights.get(6),destinationdate,false,'f',flights.get(4),flights.get(5)));
     System.out.println(route.findAll());
  //json =  json + "," + createWeatherJson ;
  return json;
 }



}
