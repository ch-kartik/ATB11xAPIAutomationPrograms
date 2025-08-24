package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab010_POST_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_POST_NonBDD(){
        // URL, Method, Payload, Body, Headers
        // Auth ?

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        System.out.println("---- Part 1 ----");

        // Part 1 - Pre Condition, Preparing Request- URL, Headers, Auth...
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType("application/json");
        r.log().all();
        r.body(payload);

        System.out.println("---- Part 2 ----");

        // Part 2 - Making HTTP Request
        response = r.when().log().all().post();

        System.out.println("---- Part 3 ----");

        // Part 3 - Verification Part
        vr = response.then().log().all();
        vr.statusCode(200);


    }
}
