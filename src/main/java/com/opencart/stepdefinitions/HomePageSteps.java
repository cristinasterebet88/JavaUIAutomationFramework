package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homepage = new HomePage(driver);

    @Given("The Home page is displayed")
    public void theHomePageIsDisplayed() {
        driver.get("https://tekwillacademy-opencart.online/");
    }
    @And("RegisterPage is accessed from HomePage buttons")
    public void registerPageIsAccessedFromHomePageButtons() {
        homepage.navigateToRegisterPage();
    }
}