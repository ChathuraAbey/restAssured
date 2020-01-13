package com.ra;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class directsample{

    static  String   AC;

    public static void login()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "";
        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = RestAssured.given()
                //.contentType(ContentType.JSON)
                .header("ContentType","JSON")
//                .body("{"
//                        + "\"username\": dantooine_agent1@mailinator.com,"
//                        + "\"password\": Ziwo@123,"
//                        + "}"
//                )
                .multiPart("username","dantooine_agent1@mailinator.com")
                .multiPart("password","Ziwo@123");
        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(Method.POST, "/auth/login");

        // Now let us print the body of the message to see what response
        // we have recieved from the server
        int code = response.getStatusCode();
        AC =  response.jsonPath().getString("access_token");
        String responseBody = response.getBody().asString();
       // System.out.println("Access Token  is =>  " + AC.toString());
        System.out.println("Response Body is =>  " + responseBody);
        System.out.println(" Status Code is => " + code);

    }

    public static void getAgents()
    {
      RestAssured.baseURI = "https://dantooine-api.aswat.co";
        RequestSpecification httpRequest = RestAssured.given()
                .header("access_token","95f000a0-1537-11ea-8319-7bc1b2a4c13d");
        Response response = httpRequest.request(Method.GET, "/admin/agents");
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);


    }


    public static void getAC()
    {
        RestAssured.baseURI = "https://dantooine-api.aswat.co";

        RequestSpecification httpRequest = RestAssured.given()
                .header("ContentType","JSON")
                .multiPart("username","dantooine_agent1@mailinator.com")
                .multiPart("password","Ziwo@123");
        Response response = httpRequest.request(Method.POST, "/auth/AdminFunction");
//        int code = response.getStatusCode();
//        String jsonpathCreatorNamePath = "$['content']['access_token']";
//        JSONObject JO=new JSONObject(response);
//        DocumentContext jsonContext = JsonPath.parse(JO);
//        String jsonpathCreatorName = jsonContext.read(jsonpathCreatorNamePath);
//        System.out.println(jsonpathCreatorName);
//        //List<String> jsonpathCreatorLocation = jsonContext.read(jsonpathCreatorNamePath);

    }
    }


