package com.thetestingacademy.ex_06_TestAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting_Lab027_RestAssured_Hard_and_Soft_Assertion {

    @Test(enabled = false)
    public void test_hardAssertionExample(){
        System.out.println("Start of the program");
        Boolean is_neeru_male = false;
        Assert.assertEquals("gemini","Gemini");     // this will fail
        System.out.println("End of the program");
    }

    @Test
    public void test_softAssertionExample(){
        System.out.println("Start of the program");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("whale","Whale");   // this will fail
        System.out.println("End of the program");
        softAssert.assertAll();
    }
}
