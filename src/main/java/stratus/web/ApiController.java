package stratus.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import stratus.FindFlights;
import stratus.HttpApiResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {




 @GetMapping("/getairportcode/{location}")
    public List<String> getAirportCode(@RequestParam String location){
     HttpApiResponse apires = new HttpApiResponse("fa7769554emshaab499374a3ea4dp179e68jsne2fbed25ad4d","skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
     ArrayList<String> airportCodes = new ArrayList<>();
     FindFlights.printLocationData(apires,location);
     
     return airportCodes;
 }



}
