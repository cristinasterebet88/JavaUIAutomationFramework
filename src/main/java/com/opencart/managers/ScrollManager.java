package com.opencart.managers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollManager {
    public static void ScrollToElement(WebElement element) {
        WebDriver driver = DriverManager.getInstance().getDriver();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
