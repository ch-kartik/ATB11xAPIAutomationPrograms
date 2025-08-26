package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab013_PATCH_NonBDDStyle {

    @Test
    public void test_PATCH_NonBDD() {
        String token = "121ed2a86892be8";
        String bookingid = "969";

        String payload = "{\n" +
                "    \"firstname\" : \"Jennifer\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept("application/json");
        requestSpecification.cookie("token", token);
        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().log().all().patch();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }

}

