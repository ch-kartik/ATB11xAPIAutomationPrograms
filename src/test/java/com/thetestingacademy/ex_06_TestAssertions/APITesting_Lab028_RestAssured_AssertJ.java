package com.thetestingacademy.ex_06_TestAssertions;

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

public class APITesting_Lab028_RestAssured_AssertJ {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;

    @Test
    public void test_POST(){

        //String Payload
        String payload_POST = "{\n" +
                "    \"firstname\" : \"Jai\",\n" +
                "    \"lastname\" : \"Varma\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept("application/json");
        requestSpecification.body(payload_POST).log().all();

        response = requestSpecification.when().log().all().post();

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();

        // Rest Assured
        validatableResponse.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers;    %4-%5
        //Matchers.equalto()

        validatableResponse.body("booking.firstname", Matchers.equalTo("Jai"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Varma"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));
        validatableResponse.body("bookingid",Matchers.notNullValue());

        // TestNG - Extract the details of firstname, lastname, bookingid from response

        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        // TestNG Assertions - 75%
        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails
        // the remaining statements in that test method will not be executed.

        Assert.assertEquals(firstname, "Jai");
        Assert.assertEquals(lastname,"Varma");
        Assert.assertNotNull(bookingId);

        //
        // AssertJ( 3rd- Lib to Assertions) - 20%
        assertThat(bookingId).isNotZero().isNotNull().isPositive();
        assertThat(firstname).isEqualTo("Jai").isNotBlank().isNotEmpty().isNotNull().isAlphanumeric();

        // String s = "";  // Empty
        // String s = " "; // Blank



    }
}
