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
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
//import java.net.http.HttpClient;
import java.util.*;

public class CurrencyAPI {

    private static Scanner scn;


    private static String getRate() throws MalformedURLException {

        String prettyJsonString = "";

        String endpoint = "latest";
        String access_key = "712b605881d34412b51d25d365875eb8";

// get the most recent exchange rates via the "latest" endpoint:

        String url = "http://data.fixer.io/api/" + endpoint + "?access_key=" + access_key;

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        try {
            //Performs the HTTP get request
            HttpResponse response = httpClient.execute(request);
            //Print the response code for testing purposes to see whether api is successful or not
            //System.out.println("Response code : " + response.getStatusLine().getStatusCode());
            //Gets the response and converts it into a JSON Object
            String json_string = EntityUtils.toString(response.getEntity());
            JSONObject myObject = new JSONObject(json_string);
            //Using Google's GSON library to pretty print the JSON Object so that its readable
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(myObject.toString());
            prettyJsonString = gson.toJson(je);
            System.out.println(prettyJsonString);






        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.getLocalizedMessage();
        }

        return prettyJsonString;
    }
    public static void printTheRate(String string){

        JSONObject myObjectData = new JSONObject(string);
        JSONObject rates= myObjectData.getJSONObject("rates");
        Float UK =rates.getFloat("GBP");

        System.out.println("Please enter the currency you would like the exchange rate of (USD, JPY, EUR or AUD");
        String country = scn.nextLine();

        Float US =rates.getFloat(country);




        System.out.println("currency rate for GBP to "+country+" is: " + (US/UK));

    }




    public static void main(String[] args) throws MalformedURLException {

        String string=getRate();
        scn = new Scanner(System.in);
        printTheRate(string);
    }
//"GBP": 0.895936,    "USD": 1.11557, "EUR": 1,

    // (1*(desired currency/GBP currency)

}

