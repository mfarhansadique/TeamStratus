package stratus;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.google.gson.*;
import org.json.JSONObject;


public class AmadeusFlightsApi {

    Amadeus amadeus = Amadeus
            .builder("4RbapAA123sW9QVA0PDHwnRkA9LVWO4u", "IIBYdRnZoRnVNED7")
            .build();

    public void getFlightInfo(){
        try {
            FlightOffer[] flightOffers = amadeus.shopping.flightOffers
                    .get(Params.with("origin", "LHR").and("destination", "NYC").and("departureDate", "2020-01-01").and("max", "5"));
            JsonObject gson = flightOffers[0].getResponse().getResult();
            JSONObject jo2 = new JSONObject(gson.toString());
            Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(jo2.toString());
            String prettyJsonString = gson2.toJson(je);
            System.out.println(prettyJsonString);
        } catch (ResponseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        AmadeusFlightsApi toUse = new AmadeusFlightsApi();

        toUse.getFlightInfo();






    }

}
