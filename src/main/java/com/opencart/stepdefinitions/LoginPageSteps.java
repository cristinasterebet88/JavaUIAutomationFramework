package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.LoginPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @And("the login form is populated with the following data:")
    public void theLoginFormIsPopulatedWithTheFollowingData(List<String> collectedDataList) {
        loginPage.completeLoginForm(collectedDataList.get(0), collectedDataList.get(1));
    }

}