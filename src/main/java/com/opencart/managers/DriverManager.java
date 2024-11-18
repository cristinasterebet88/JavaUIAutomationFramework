package com.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.sql.SQLOutput;

public class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;
    private static final String WEB_DRIVER_TYPE = "Chrome";

    private DriverManager() {
        switch (WEB_DRIVER_TYPE.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("The Chrome driver is opened");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The Firefox driver is opened");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The Edge driver is opened");
                break;
            case "SAFARI":
                driver = new SafariDriver();
                System.out.println("The Safari driver is opened");
                break;
            default:
                System.out.println("The browser type is not defined: " + WEB_DRIVER_TYPE);
        }
    }

    //Metoda statica pentru a obtine instanta Singleton
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    //Metoda publica pentru a obtine driverul web
    public WebDriver getDriver() {
        return driver;
    }
}
