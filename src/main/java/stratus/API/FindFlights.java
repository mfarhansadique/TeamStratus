package stratus.API;

import java.util.Scanner;

public class FindFlights {

    private static Scanner scn;

    static String apiKey = "fa7769554emshaab499374a3ea4dp179e68jsne2fbed25ad4d";
    static String host = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";


    /**
     * This method uses Scanner and System in to get inputs to perform a location query which will print a JSON Object
     * containing all the corresponding Airports associated with the string using the getResponse method.
     */
    private static void printLocationData(HttpApiResponse resP){
        System.out.println("Please enter a location");
        String localInput = scn.next();
        String url = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/UK/GBP/en-GB/?query="+localInput;
        System.out.println(resP.getRapidApiResponse(url));
    }
    /**
     * This method uses Scanner and System in to get inputs to perform a quotes for flights search which will print a
     * JSON Object containing airlines, currency info, and prices for 'to' and 'from' the location using the getResponse
     * method.
     */
    private static void printQuoteData(HttpApiResponse resP){
        System.out.println("Please enter a Destination");
        String destination = scn.next() +"-sky";
        System.out.println("Please enter your chosen airport");
        String arrival = scn.next()+"-sky";
        System.out.println("Please enter your departure date");
        String depDate = scn.next();
        System.out.println("Please enter your arrival date");
        String arrDate = scn.next();
        String url = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browseroutes/v1.0/UK/GBP/en-GB/"+arrival+"/"+destination+"/"+depDate+"?inboundpartialdate="+arrDate;
        System.out.println(resP.getRapidApiResponse(url));
    }
    /**
     * This method gives options to choose in the command line environment to choose whether they want to search a quote
     *  or a list of airlines.
     */
    private static void chooseInput (HttpApiResponse resP){

        System.out.println("press 1 to search airports or press 2 for quote or x for exit");
        String input = scn.next();
        input = input.toLowerCase();

        if (input.equals("1")){
            printLocationData(resP);
            chooseInput(resP);
        } else if (input.equals("2")){
            printQuoteData(resP);
            chooseInput(resP);
        } else if (input.equals("x")){
            scn.close();
        } else {
            chooseInput(resP);
        }

    }

    public static void main(String[] args) {
        scn = new Scanner(System.in);
        HttpApiResponse resP = new HttpApiResponse(apiKey,host);
        chooseInput(resP);
    }

}