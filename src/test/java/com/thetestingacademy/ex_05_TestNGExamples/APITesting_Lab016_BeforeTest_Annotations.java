package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting_Lab016_BeforeTest_Annotations {

    // PUT Request
    // 1. getToken
    // 2. getBookingId
    // 3. test_PUT ( which will use the above two methods )
    // 4. closeAllThings

    @BeforeTest
    public void getToken(){
        System.out.println(" Before GET Token");
    }

    @BeforeTest
    public void getBookingId(){
        System.out.println(" Before GET Booking");
    }

    @Test
    public void test_PUT(){
        System.out.println(" PUT Request");
    }

    @AfterTest
    public void closeAllThings(){
        System.out.println(" Close");
    }
}
