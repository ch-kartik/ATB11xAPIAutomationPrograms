package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab008_GET_BDDStyle {

    @Test
    public void test_GET_POSITIVE(){
        String pincode = "388620";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pincode)
                .when()
                    .log()
                    .all()
                    .get()
                .then()
                    .log().all()
                    .statusCode(200);
    }
    }

