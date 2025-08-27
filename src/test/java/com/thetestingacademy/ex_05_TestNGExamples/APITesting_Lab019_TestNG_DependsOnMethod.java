package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_Lab019_TestNG_DependsOnMethod {

    @Test
    public void serverStartedOK(){
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOK")
    public void test1(){
        System.out.println("method1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOK")
    public void test2(){
        System.out.println("method2");
        Assert.assertTrue(true);
    }
}
