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

        System.out.println("Please enter the origin of your travel");//to code later: if enter several words need to be separated by +
        String origin = scn.next();

        System.out.println("Please enter your destination");
        String destination= scn.next();

        System.out.println("Please enter your mode of transport between walking, driving, bicycling, and transit");
        String mode= scn.next();


        String prettyJsonString = "";
        //API keys from Googlemaps API docs
        String apiKey = "AIzaSyBktdACICn5zDhtfxywVJRRUuB53aE1V-I";

//Example:
        //String origin = "Disneyland";
        //String destination = "Universal Studios";
        //String mode ="driving";//walking, driving, bicycling, transit
        //lots of other options can be added


        //Creates a HTTPClient to start the query from the api
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://maps.googleapis.com/maps/api/directions/json?origin="+origin+"&destination="+destination+"&mode="+mode+"&key="+apiKey);
        //Pass in using the headers the keys and host info to the get request


        System.out.println(request);
        try {
            //Performs the HTTP get request
            HttpResponse response = httpClient.execute(request);



            //Print the response code for testing purposes to see whether api is successful or not
            System.out.println("Response code : "+ response.getStatusLine().getStatusCode());
            //Gets the response and converts it into a JSON Object
            String json_string = EntityUtils.toString(response.getEntity());


            JSONObject myObject = new JSONObject(json_string);

            //Using Google's GSON library to pretty print the JSON Object so that its readable
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(myObject.toString());
            prettyJsonString = gson.toJson(je);
            //System.out.println(prettyJsonString);

            //Not working yet but trying to read JSON:





        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.getLocalizedMessage();
        }
        return prettyJsonString;
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


