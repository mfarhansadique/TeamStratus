package stratus.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.JSONObject;

public class PrettyJSON {
    public static String print(String json_string){
        JSONObject myObject = new JSONObject(json_string);

        //Using Google's GSON library to pretty print the JSON Object so that its readable
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(myObject.toString());
        String prettyJsonString = gson.toJson(je);
        //System.out.println(prettyJsonString);
        return prettyJsonString;

    }
    public static void main(String[] args) {

    }
}
