package com.cydeo.tests.day08_properties_config_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_test() throws IOException {

        //1- Create object of Properties
        //We need to open the file in the Java memory
        //3- Load the properties file in the Properties object
        //4- Use the "Properties" object to read value from the file

        Properties properties= new Properties();

        FileInputStream file = new FileInputStream("configuration.properties");

        properties.load(file);
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));

        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        System.out.println("properties.getProperty(\"password\") = " + properties.getProperty("password"));

    }
}
