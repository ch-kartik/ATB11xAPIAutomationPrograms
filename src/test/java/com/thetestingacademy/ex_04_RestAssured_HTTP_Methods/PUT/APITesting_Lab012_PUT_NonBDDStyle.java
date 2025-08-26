package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab012_PUT_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_PUT_NonBDD(){

        String token = "ba311f339130191";
        String bookingid = "1114";

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"Jenny\",\n" +
                "    \"lastname\" : \"Salvador\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);
        r.contentType(ContentType.JSON);
        r.accept("application/json");
        r.cookie("token", token);
        r.body(payloadPUT).log().all();

        response = r.when().log().all().put();

        vr = response.then().log().all();
        vr.statusCode(200);

    }
}
