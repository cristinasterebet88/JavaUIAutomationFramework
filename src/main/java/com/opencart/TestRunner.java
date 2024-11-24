package com.opencart;

import com.opencart.managers.DataGeneratorManager;
import com.opencart.managers.DriverManager;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        //DriverManager.getInstance().getDriver().get("https://tekwillacademy-opencart.online/");
        //Sau:
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentTabName = driver.getWindowHandle();

        //Open new window and navigate to Opencart page
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("The current URL is: " + driver.getCurrentUrl());
        System.out.println("The current page title: " + driver.getTitle());

        WebElement myAccountDropDownIcon = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/div/a/span"));
        myAccountDropDownIcon.click();
        WebElement registerOLink = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/div/ul/li[1]/a"));
        registerOLink.click();
        Thread.sleep(3000);

        //Print the url of the new page
        System.out.println("The current URL is: " + driver.getCurrentUrl());
        System.out.println("The current page title: " + driver.getTitle());

        WebElement firstNAmeInput = driver.findElement(By.id("input-firstname"));
        firstNAmeInput.sendKeys(DataGeneratorManager.getRandomFirstName());
        WebElement lastNAmeInput = driver.findElement(By.id("input-lastname"));
        firstNAmeInput.sendKeys(DataGeneratorManager.getRandomLastName());

        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
        String emailData = DataGeneratorManager.getRandomPassword();
        System.out.println("Email: " + emailData);
        emailInput.sendKeys(emailData);

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String passwordData = DataGeneratorManager.getRandomPassword();
        System.out.println("Password: " + passwordData);
        passwordInput.sendKeys(passwordData);

        WebElement privacyToggleBar = driver.findElement(By.xpath("//input[@name='agree']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyToggleBar);
        Thread.sleep(500);

        privacyToggleBar.click();

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        Thread.sleep(3000);

        //Close the current tab
        driver.close();
        driver.quit();
    }
}