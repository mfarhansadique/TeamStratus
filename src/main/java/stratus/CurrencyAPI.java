package stratus;

import org.json.JSONObject;

import java.util.*;

public class CurrencyAPI {

    private static Scanner scn;


    private static String getRate()  {


        String endpoint = "latest";
        String access_key = "712b605881d34412b51d25d365875eb8";

// get the most recent exchange rates via the "latest" endpoint:


        HttpApiResponse har =new HttpApiResponse();
        String jsonString= har.getRapidApiResponse("http://data.fixer.io/api/" + endpoint + "?access_key=" + access_key);
        System.out.println(PrettyJSON.print(jsonString));
        return PrettyJSON.print(jsonString);
    }

    public static void printTheRate(String string){

        JSONObject myObjectData = new JSONObject(string);
        JSONObject rates= myObjectData.getJSONObject("rates");
        Float UK =rates.getFloat("GBP");

        System.out.println("Please enter the currency you would like the exchange rate of (USD, JPY, EUR or AUD");
        String country = scn.nextLine();

        Float countryC =rates.getFloat(country);

        System.out.println("currency rate for GBP to "+country+" is: " + (countryC/UK));

    }




    public static void main(String[] args)  {

        String string=getRate();
        scn = new Scanner(System.in);
        printTheRate(string);
    }
//"GBP": 0.895936,    "USD": 1.11557, "EUR": 1,

    // (1*(desired currency/GBP currency)

}

