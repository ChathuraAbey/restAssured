package com.aux.ra;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utill.Utility;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class directsample extends Utility {

    static String token;

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        login();
        Parameterize();
        getAgents();

    }

    public static void login()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = baseUrl();
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
                .multiPart("username",UserName())
                .multiPart("password",Password());
        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(Method.POST, "/auth/login");

        // Now let us print the body of the message to see what response
        // we have recieved from the server
        int code = response.getStatusCode();
        String responseBody = response.getBody().asString();

       // System.out.println("Access Token  is =>  " + AC.toString());
        System.out.println("Response Body is =>  " + responseBody);
        System.out.println(" Status Code is => " + code);
        //System.out.println("Access Token extracted ----->"+AC);

    }

    public static void getAgents()
    {
      RestAssured.baseURI = baseUrl();
        RequestSpecification httpRequest = RestAssured.given()
                .header("access_token",token);
        Response response = httpRequest.request(Method.GET, "/admin/agents");
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);


    }
    public static void Parameterize() {

        RestAssured.baseURI = baseUrl();
        token =   given()
                //.contentType(ContentType.JSON)
                .header("ContentType","JSON")
                .multiPart("username",UserName())
                .multiPart("password",Password())
                .post("/auth/login")
                .then().assertThat().statusCode(200)
                .extract().response().path("content.access_token").toString();
        System.out.println(token);
        //Feeded Request
        //RestAssured.baseURI = "https://dantooine-api.aswat.co";
        given().header("access_token",token).
                when().
                get("/admin/agents").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                header("Server",equalTo("nginx"));

    }


   }


