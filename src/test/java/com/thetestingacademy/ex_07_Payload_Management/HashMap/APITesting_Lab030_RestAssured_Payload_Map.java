package com.thetestingacademy.ex_07_Payload_Management.HashMap;

import static org.assertj.core.api.Assertions.*;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class APITesting_Lab030_RestAssured_Payload_Map {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;

    @Test
    public void test_POST() {
        //String Payload
//    String payload_POST = "{\n" +
//            "    \"firstname\" : \"Jai\",\n" +
//            "    \"lastname\" : \"Varma\",\n" +
//            "    \"totalprice\" : 111,\n" +
//            "    \"depositpaid\" : true,\n" +
//            "    \"bookingdates\" : {\n" +
//            "        \"checkin\" : \"2018-01-01\",\n" +
//            "        \"checkout\" : \"2019-01-01\"\n" +
//            "    },\n" +
//            "    \"additionalneeds\" : \"Breakfast\"\n" +
//            "}";

        // HashMap -> Key and Value
        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname", "Jai");
        jsonBodyUsingMap.put("lastname", "Varma");
        jsonBodyUsingMap.put("totalprice", 123);
        jsonBodyUsingMap.put("depositpaid", false);

        Map<String, Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        System.out.println(jsonBodyUsingMap);

        // Convert output form HashMap -> JSON
        // There are two libraries available (use any one)
        // 1. gson
        // 2. jackson API

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept("application/json");
        requestSpecification.body(jsonBodyUsingMap).log().all();

        response = requestSpecification.when().log().all().post();

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();

        // Rest Assured
        validatableResponse.statusCode(200);

    }
}
