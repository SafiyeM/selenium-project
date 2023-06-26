package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class Understanding_closeDriver_method {


    @Test
    public void test1() {

        Driver.getDriver().get("https://google.com");

        //verify something
        //Driver.getDriver()  --> this method returns me brand new driver!

        // Driver.getDriver().quit(); // if we add quit() method after each test,
                                      // it runs only test1 and after that kills the session.
                                      // Therefore, other tests will not be executed.
                                      // We get-> NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?

       // Driver.getDriver().close(); // we get the same exception, if we add close() method after each test, with different message.
                                      // -> NoSuchSessionException: invalid session id

        Driver.closeDriver(); // -> This util method will use .quit() method to quit browsers and then set the driver value back to null.
                              // we created in this utility method Singleton Pattern
    }


    @Test
    public void test2() {

        Driver.getDriver().get("https://google.com");
        //verify something else
        // Driver.getDriver().quit();
        // Driver.getDriver().close();
        Driver.closeDriver();
    }


    @Test
    public void test3() {

        Driver.getDriver().get("https://google.com");

        //verify something completely different

        // Driver.getDriver().quit();
        // Driver.getDriver().close();
        Driver.closeDriver();

    }


}
