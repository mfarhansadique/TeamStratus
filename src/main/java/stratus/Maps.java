package stratus;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class Maps {

    private static Scanner scn;
    /*
     * This class takes the URL, and with the API keys will use HTTP client to get a response to form a JSON object.
     * @param url Provide the URL to to get the api JSON response from
     */
    private static String getResponse(){//asks for a few basic information for the trip

        System.out.println("Please enter the origin of your travel");
        String origin = scn.nextLine();
        origin=origin.replaceAll("\\s","+");

        System.out.println("Please enter your destination");
        String destination= scn.nextLine();
        destination=destination.replaceAll("\\s","+");

        System.out.println("Please enter your mode of transport between walking, driving, bicycling, and transit");
        String mode= scn.next();


        //API keys from Googlemaps API docs
        String apiKey = "AIzaSyBktdACICn5zDhtfxywVJRRUuB53aE1V-I";

//Example:
        //String origin = "Disneyland";
        //String destination = "Universal Studios";
        //String mode ="driving";//walking, driving, bicycling, transit
        //lots of other options can be added


        //Creates a HTTPClient to start the query from the api
        HttpApiResponse har =new HttpApiResponse();
        String jsonString= har.getRapidApiResponse("https://maps.googleapis.com/maps/api/directions/json?origin="+origin+"&destination="+destination+"&mode="+mode+"&key="+apiKey);

        return PrettyJSON.print(jsonString);
    }




public static void dataFromAPI(String string){//chose to return the duration and distance of the trip as an example
    JSONObject myObjectData = new JSONObject(string);
    JSONArray routes = myObjectData.getJSONArray("routes");
    JSONObject routes1 = routes.getJSONObject(0);
    JSONArray legs =routes1.getJSONArray("legs");
    JSONObject trip=legs.getJSONObject(0);
    String duration= trip.getJSONObject("duration").getString("text");
    String distance= trip.getJSONObject("distance").getString("text");
    System.out.println("duration:"+duration+"\tdistance:"+distance);
}



    public static void main(String[] args) {
        scn = new Scanner(System.in);
        String string= getResponse();
        dataFromAPI(string);

    }

}


