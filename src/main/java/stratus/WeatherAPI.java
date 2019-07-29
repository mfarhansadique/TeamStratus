package stratus;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Scanner;

public class WeatherAPI {
//Ignore

    private static Scanner scn;

    private static String apiKey = "fa7769554emshaab499374a3ea4dp179e68jsne2fbed25ad4d";
    private static String host = "dark-sky.p.rapidapi.com";
    private static String host2 = "airport-info.p.rapidapi.com";
    private static HttpApiResponse apiCaller = new HttpApiResponse(apiKey,host);
    private static HttpApiResponse apiCaller2 = new HttpApiResponse(apiKey,host2);

    private static String getWeatherByLatLon(String lat, String lon){
        return apiCaller.getRapidApiResponse("https://dark-sky.p.rapidapi.com/"+ lat +","+ lon +"?lang=en&units=auto");

    }
    private static String[] breaksMapsOutput(String bigString){ //built to come after Maps.getCoordinates, returns two responses for start and finish

        String[] parts = bigString.split("-");
        String startB=parts[0];
        String endB=parts[1];
        String[] partS=startB.split(",");
        String[] partE=endB.split(",");

        String a= getWeatherByLatLon(partS[0],partS[1]);
        String b= getWeatherByLatLon(partE[0],partE[1]);
        String[] array={a,b};
        return array;

    }

    private static String getWeatherByAirportCode(String airportCode){
        double lat;
        double lon;
        JSONObject toGet = new JSONObject(apiCaller2.getRapidApiResponse("https://airport-info.p.rapidapi.com/airport?iata="+airportCode));
        lat = toGet.getDouble("latitude");
        lon = toGet.getDouble("longitude");
        getWeatherByLatLon(Double.toString(lat),Double.toString(lon));
        return getWeatherByLatLon(Double.toString(lat),Double.toString(lon));
    }

    private static String[] outputWeatherNow(String string){
        JSONObject myObjectData = new JSONObject(string);
        Float temp= myObjectData.getJSONObject("currently").getFloat("temperature");

        String summary=myObjectData.getJSONObject("currently").getString("icon");
        String icon=myObjectData.getJSONObject("currently").getString("summary");
        String temps=temp.toString();

        String[] result=new String[]{temps,icon,summary};
        return result;
    }


    private static String[] outputWeatherWeek(String string, int dayDiff){
        //dayDiff is the amount of days of difference between today and the day of interest plus 1. So if it is Monday and we want Tuesday we need to enter 2
        JSONObject myObjectData = new JSONObject(string);
        String[] result=new String[3];

        if((0<=dayDiff)&&(dayDiff<=6)){
            Float temp =myObjectData.getJSONObject("daily").getJSONArray("data").getJSONObject(dayDiff).getFloat("temperature");
            result[0]=temp.toString();
            result[1]=myObjectData.getJSONObject("daily").getJSONArray("data").getJSONObject(dayDiff).getString("icon");
             result[2]=myObjectData.getJSONObject("daily").getJSONArray("data").getJSONObject(dayDiff).getString("summary");

        return result;
        }
        return result;
    }

    /*Not ready yet

    private static String[] outputWeatherPast(String lat, String lon, String time){

        String string=PrettyJSON.print(apiCaller.getRapidApiResponse("https://dark-sky.p.rapidapi.com/"+ lat +","+ lon +","+time+"?lang=en&units=auto"));
        JSONObject myObjectData = new JSONObject(string);
        Float temp= myObjectData.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getFloat("temperature");

        String summary=myObjectData.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getString("icon");
        String icon=myObjectData.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getString("summary");
        String temps=temp.toString();

        String[] result=new String[]{temps,icon,summary};
        return result;
    }*/

    public static void main(String[] args) {
        scn = new Scanner(System.in);
        System.out.println(PrettyJSON.print(getWeatherByLatLon("51.89381100000001","-0.2873046")));
        //System.out.println(Arrays.toString(outputWeatherNow(getWeatherByLatLon("51.89381100000001","-0.2873046"))));

    }
}
