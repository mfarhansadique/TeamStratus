package stratus.web;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import stratus.API.HttpApiResponse;
import stratus.AirportInformation;
import stratus.AmadeusFlightsApi;
import stratus.DAO.RouteDAO;

import java.util.List;

@RestController
public class ApiController {




 @GetMapping("/getairportcode/{location}")
 @ResponseBody
    public String getAirportCode(@PathVariable("location") String location){
     HttpApiResponse apires = new HttpApiResponse("fa7769554emshaab499374a3ea4dp179e68jsne2fbed25ad4d","skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
     List<String> airportCodes = AirportInformation.printLocationData(apires,location);
     String json = new Gson().toJson(airportCodes);
     System.out.println(json);
     return json;
 }

 @GetMapping("/getFlight")
 @ResponseBody
 public ModelAndView getFlight(@RequestParam String destinationcode, @RequestParam String arrivalcode, @RequestParam String destinationdate){
  ModelAndView mv = new ModelAndView();
  JSONObject flights = AmadeusFlightsApi.getFlightInfo(arrivalcode,destinationcode,destinationdate);
  String json = flights.toString();
  System.out.println(json);
  mv.addObject(json);
  return mv;
 }



}
