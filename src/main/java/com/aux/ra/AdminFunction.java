package com.aux.ra;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utill.Utility;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AdminFunction extends Utility {

    static String token;

    public static void AdminLogin()
    {

        RestAssured.baseURI =baseUrl();
        RequestSpecification httpRequest = given()
                //.contentType(ContentType.JSON)
                .header("ContentType","JSON")
                .multiPart("username",UserName())
                .multiPart("password",Password());
        Response response = httpRequest.request(Method.POST, "/auth/login");
        int code = response.getStatusCode();
        //String responseBody = response.getBody().asString();
        //System.out.println("Response Body is =>  " + responseBody);
        //System.out.println(" Status Code is => " + code);

    }

    public static void adminGetAgents()
    {
        RestAssured.baseURI = baseUrl();
        RequestSpecification httpRequest = given()
                .header("access_token",token);
        Response response = httpRequest.request(Method.GET, "/admin/agents");
        String responseBody = response.getBody().asString();

    }

    public void test_ResponseHeaderLength_ShouldBeCorrect() {

        RestAssured.baseURI = baseUrl();
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

   public void Parameterize() {

       RestAssured.baseURI = baseUrl();
               token =   given()
               //.contentType(ContentType.JSON)
               .header("ContentType","JSON")
               .multiPart("username",UserName())
               .multiPart("password",Password())
               .post("/auth/login")
               .then().assertThat().statusCode(200)
                        .extract().response().path("content.access_token").toString();
               // System.out.println(token);
                //Feeded Request
       RestAssured.baseURI = baseUrl();
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


