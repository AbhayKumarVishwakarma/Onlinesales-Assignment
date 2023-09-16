package com.onlinesales;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public List<String> evaluateMathematicalExpression(List<String> list){

        List<String> resultList = new ArrayList<>();

        String url = "http://api.mathjs.org/v4/";

        // Convert the ArrayList to a JSON string
        String jsonBody = "{\"expr\": [" + String.join(",", list.stream().map(expr -> "\"" + expr + "\"").toArray(String[]::new)) + "]}";

        try{
            // Create an HttpRequest using a Builder pattern
            HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();

            // Send the HttpRequest and receive an HttpResponse
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Check the response code
            int statusCode = response.statusCode();

            if (statusCode == 200) {
                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.body());

                // Extract the "result" array
                JSONArray resultArray = jsonResponse.getJSONArray("result");

                for (int i = 0; i < resultArray.length(); i++) {
                    resultList.add(resultArray.getString(i));
                }
            }
            else resultList.add("Error in mathematical expression!");
        }
        catch (IOException | InterruptedException ex){
            ex.printStackTrace();
        }

        return resultList;
    }

    public static void main(String[] args) {
        List<String> list = List.of("2 * 4 * 4", "5 / (7 - 5)", "sqrt(5^2 - 4^2)", "sqrt(-3^2 - 4^2)");

        Main main = new Main();
        List<String> resultList = main.evaluateMathematicalExpression(list);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i) + " ==> " + resultList.get(i));
        }

        /**
         * Output
            2 * 4 * 4 ==> 32
            5 / (7 - 5) ==> 2.5
            sqrt(5^2 - 4^2) ==> 3
            sqrt(-3^2 - 4^2) ==> 5i
         */

    }
}