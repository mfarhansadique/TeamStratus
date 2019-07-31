package stratus.web;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stratus.API.*;
import stratus.DAO.Route;
import stratus.DAO.RouteDAO;


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



 @GetMapping("/getflight/{destinationcode}/{arrivalcode}/{destinationdate}")
 @ResponseBody
 public String getFlight(@PathVariable("destinationcode") String destinationcode, @PathVariable("arrivalcode") String arrivalcode, @PathVariable("destinationdate") String destinationdate){
  JSONObject flights = AmadeusFlightsApi.getFlightInfo(arrivalcode,destinationcode,destinationdate);
  String destinationWeather = WeatherAPI.getWeatherByAirportCode(destinationcode);
  String arrivalWeather = WeatherAPI.getWeatherByAirportCode(arrivalcode);
  String createWeatherJson = "{\"destinationWeather\":"+destinationWeather + ",\"arrivalWeather\":"+arrivalWeather+"}";
  String json = flights.toString();
  route.save(new Route(json,json,json,json,json,json,json,null));

  //json =  json + "," + createWeatherJson ;
  return json;
 }

 @GetMapping("/getmaps/{start}/{destination}/{date}/{transportMethod}")//url
 @ResponseBody
public String getRouteFromFlight(@PathVariable("start") String start, @PathVariable("destination") String destination, @PathVariable("date")String date, @PathVariable("transportMethod")char transportMethod){
  Route routeMaps=Maps.makeRoute(start, destination, date,transportMethod);
  route.save( routeMaps );
  return routeMaps.getRouteDetails();
 }



}
