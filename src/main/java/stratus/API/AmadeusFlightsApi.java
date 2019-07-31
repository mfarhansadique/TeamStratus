package stratus.API;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.google.gson.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import stratus.API.AirportInformation;
import stratus.DAO.Route;
import stratus.DAO.RouteDAO;

import java.util.ArrayList;
import java.util.Arrays;


public class AmadeusFlightsApi {




    public static ArrayList<String> getFlightInfo(String originAirport,String destinationAirport,String departureDate){
        Amadeus amadeus = Amadeus.builder("4RbapAA123sW9QVA0PDHwnRkA9LVWO4u", "IIBYdRnZoRnVNED7").build();
        ArrayList<String> items = new ArrayList<>();
        JSONObject toReturn = new JSONObject();
        try {
            FlightOffer[] flightOffers = amadeus.shopping.flightOffers
                    .get(Params.with("origin", originAirport).and("destination", destinationAirport).and("departureDate", departureDate).and("max", "1"));
            JsonObject gson = flightOffers[0].getResponse().getResult();
            for (int i = 0; i < flightOffers[0].getOfferItems().length; i++) {
                //System.out.println(flightOffers[0].getOfferItems()[i].getServices()[i].getSegments()[i].getFlightSegment().getDeparture());
            }
            //System.out.println(flightOffers[0].getOfferItems().toString());
            toReturn = new JSONObject(gson.toString());

            String longLatOrigin = AirportInformation.getLongLatofAirport(originAirport);
            String longLatDestination = AirportInformation.getLongLatofAirport(destinationAirport);
            String[] originInfo = longLatOrigin.split(",");
            String[] destinationInfo = longLatDestination.split(",");
            items.add(toReturn.toString());
            items.addAll(Arrays.asList(originInfo));
            items.addAll(Arrays.asList(destinationInfo));
            String countryCode = Maps.getCountryCode(destinationInfo[0],destinationInfo[1]);
            String currencyCode = CurrencyAPI.currencyByCountry(countryCode);
            items.add(currencyCode);
            //new Route(toReturn.toString(),originInfo[2],destinationInfo[2],originInfo[0],originInfo[1],destinationInfo[0],destinationInfo[1],null);

        } catch (ResponseException e) {
            e.printStackTrace();
        }

        for (String toPr: items
             ) {
            System.out.println(toPr);
        }

        return items;

    }

}
