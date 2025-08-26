package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.Base64;

public class APITesting_Lab014_DELETE_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_DELETE_NonBDD(){

        String token = "d6593f6b3255872";
        String bookingid = "661";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.log().all();

        response = r.when().log().all().delete();

        vr = response.then().log().all();
        vr.statusCode(201);

    }
}
