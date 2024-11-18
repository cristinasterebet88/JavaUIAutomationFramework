package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import static java.sql.DriverManager.getDriver;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        //DriverManager.getInstance().getDriver().get("https://www.google.co.uk/");
        //Sau:
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.co.uk/");

        String theNameOfTheFirsTab = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://diez.md/");
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(theNameOfTheFirsTab);
        driver.get("https://www.stiri.md/");
        Thread.sleep(2000);
        driver.quit();

    }
}