package com.aux.ra;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class AdminFunction {

    public static void AdminLogin()
    {

        RestAssured.baseURI = "https://dantooine-api.aswat.co";
        RequestSpecification httpRequest = given()
                //.contentType(ContentType.JSON)
                .header("ContentType","JSON")
                .multiPart("username","dantooine_agent1@mailinator.com")
                .multiPart("password","Ziwo@123");
        Response response = httpRequest.request(Method.POST, "/auth/login");
        int code = response.getStatusCode();
        //String responseBody = response.getBody().asString();
        //System.out.println("Response Body is =>  " + responseBody);
        //System.out.println(" Status Code is => " + code);

    }

    public static void adminGetAgents()
    {
        RestAssured.baseURI = "https://dantooine-api.aswat.co";
        RequestSpecification httpRequest = given()
                .header("access_token","95f000a0-1537-11ea-8319-7bc1b2a4c13d");
        Response response = httpRequest.request(Method.GET, "/admin/agents");
        String responseBody = response.getBody().asString();
        //System.out.println("Response Body is =>  " + responseBody);


    }


    public void test_ResponseHeaderLength_ShouldBeCorrect() {

        RestAssured.baseURI = "https://dantooine-api.aswat.co";
        given().header("access_token","95f000a0-1537-11ea-8319-7bc1b2a4c13d").
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

   public void Parameterize() {

       RestAssured.baseURI = "https://dantooine-api.aswat.co";
             String  token =   given()
               //.contentType(ContentType.JSON)
               .header("ContentType","JSON")
               .multiPart("username","chathura.abeywickrama@aswat-telecom.com")
               .multiPart("password","Ziwo@123")
               .post("/auth/login")
               .then().assertThat().statusCode(200)
                        .extract().response().path("content.access_token").toString();
               // System.out.println(token);
                //Feeded Request
       RestAssured.baseURI = "https://dantooine-api.aswat.co";
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


