package stratus.API;
import org.json.JSONArray;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringJoiner;

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
        String transit_mode="N";
        boolean pref= false;
        if (mode=="transit"){
            System.out.println("Do you have a preferred mode of transit? (N for No, bus, subway, train, tram, rail)");
            transit_mode= scn.next();
            if (transit_mode!="N"){pref=true; }
        }


        //if specified then billed more so only specify it when not now, or if want transit then add now

        System.out.println("Please enter your departure time: N for now or yyyy-MM-dd at HH:mm");
        String depTime= stringToTime(scn.next());



        //API keys from Googlemaps API docs
        String apiKey = "AIzaSyBktdACICn5zDhtfxywVJRRUuB53aE1V-I";


        //Creates a HTTPClient to start the query from the api
        HttpApiResponse har =new HttpApiResponse();
        String jsonString;
        if((depTime=="now") && (mode=="driving")){
           jsonString = har.getApiResponse("https://maps.googleapis.com/maps/api/directions/json?origin=" + origin + "&destination=" + destination + "&mode=" + mode + "&key=" + apiKey);
        }
        else {
            if((mode=="transit") && (pref==true)){
                jsonString = har.getApiResponse("https://maps.googleapis.com/maps/api/directions/json?origin=" + origin + "&destination=" + destination + "&mode=" + mode + "&departure_time" + depTime +"&transit_mode="+transit_mode+ "&key=" + apiKey);
            }
            else {jsonString = har.getApiResponse("https://maps.googleapis.com/maps/api/directions/json?origin=" + origin + "&destination=" + destination + "&mode=" + mode + "&departure_time" + depTime + "&key=" + apiKey);
        }
        }
        return PrettyJSON.print(jsonString);
    }

private static String stringToTime(String string){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm");
    try {Date dt = sdf.parse(string);
    long epoch = dt.getTime();
    return Long.toString(epoch/1000);}

    catch(ParseException e){return "now";}

}


public static void dataFromAPI(String string){//chose to return the duration and distance of the trip as an example
    JSONObject myObjectData = new JSONObject(string);
    JSONArray routes = myObjectData.getJSONArray("routes");
    System.out.println("There are "+routes.length()+" route(s).");
    for(int i=0; i<routes.length();i++){
        JSONObject routesElement = routes.getJSONObject(0);
        JSONArray legs =routesElement.getJSONArray("legs");
        JSONObject trip=legs.getJSONObject(0);
        String duration= trip.getJSONObject("duration").getString("text");
        String distance= trip.getJSONObject("distance").getString("text");
        System.out.println("duration:"+duration+"\tdistance:"+distance);
    }

}

public static String getCoordinates(String string){ //method that can be added to get the coordinates for the weather
    JSONObject myObjectData = new JSONObject(string);
    JSONArray routes = myObjectData.getJSONArray("routes");
    JSONObject routes1 = routes.getJSONObject(0);
    JSONArray legs =routes1.getJSONArray("legs");
    JSONObject trip=legs.getJSONObject(0);
    JSONObject endPlace=trip.getJSONObject("end_location");
    JSONObject startPlace=trip.getJSONObject("start_location");
    StringJoiner latLong= new StringJoiner(" ");

    latLong.add(startPlace.getString("lat")+",");
    latLong.add(startPlace.getString("lng"));
    latLong.add("-");
    latLong.add(endPlace.getString("lat")+",");
    latLong.add(endPlace.getString("lng"));

    return latLong.toString();


//would be great to find something else that doesn't use Google Maps for prices concerns

}

public static String getCountryCode(String lat, String lng) {
    String apiKey = "AIzaSyBktdACICn5zDhtfxywVJRRUuB53aE1V-I";
    HttpApiResponse har = new HttpApiResponse();
    String jsonString = har.getApiResponse("https://maps.googleapis.com/maps/api/geocode/json?latlng=" + lat + "," + lng + "&key=" + apiKey);
    String j = PrettyJSON.print(jsonString);
    JSONObject myObjectData = new JSONObject(j);
    JSONArray results = myObjectData.getJSONArray("results").getJSONObject(0).getJSONArray("address_components");
    for (int i = 0; i < results.length(); i++) {
        JSONArray u = results.getJSONObject(i).getJSONArray("types");
        System.out.println(u);
        if (u.getString(0).equals("country") ){
            return results.getJSONObject(i).getString("short_name");
        }


    }
    return "GBP";
}

    public static void main(String[] args) {
        scn = new Scanner(System.in);
        String string= getResponse();
        dataFromAPI(string);


    }


    }



