package com.cydeo.tests.day05_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_intro {

    @BeforeClass
    public void setUpClass(){
        System.out.println("---> Before class is running!!!");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("---> After class is running!!!");
    }

    @BeforeMethod
    public void setupMethod(){
        System.out.println("---> Before method is running...");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("--> After method is running...");
    }

   @Test (priority = 1)
    public void test1(){

       System.out.println("Test 1 is running...");

       //Assert Equals method will compare two of the same values. If returns true, pass. If false, fail.
       String actual = "apple";
       String expected = "apple";
       Assert.assertEquals(actual, expected);
    }

    @Test (priority = 2)
    public  void test2(){
        System.out.println("Test 2 is running...");
        String actual = "white";
        String expected = "white";
        Assert.assertTrue(actual.equals(expected));
    }

/*
---> Before class is running!!!

---> Before method is running...
Test 1 is running...
--> After method is running...

---> Before method is running...
Test 2 is running...
--> After method is running...

---> After class is running!!!

===============================================
Default Suite
Total tests run: 2, Passes: 2, Failures: 0, Skips: 0
===============================================
 */

}
