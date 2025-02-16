package com.opencart.stepdefinitions;

import com.opencart.managers.DataGeneratorManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the registration form is populated with valid random data")
    public void theRegistrationFormIsPopulatedWithValidRandomData() {
        //Generate random data
        String firstName = DataGeneratorManager.getRandomFirstName();
        String lastName = DataGeneratorManager.getRandomLastName();
        String email = DataGeneratorManager.getRandomEmail();
        String password = DataGeneratorManager.getRandomPassword();

        registerPage.completeRegisterForm(firstName, lastName, email, password);
    }

    @When("the register form is populated as follows:")
    public void theRegisterFormIsPopulatedAsFollows(Map<String, String> userDetailMap) {
        String firstNameValue = userDetailMap.get("firstName");
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")) {
            firstNameValue = DataGeneratorManager.getRandomFirstName();
        }
        String lastNameValue = userDetailMap.get("lastName");
        if (lastNameValue != null && lastNameValue.toUpperCase().equals("RANDOM")) {
            lastNameValue = DataGeneratorManager.getRandomLastName();
        }
        String emailValue = userDetailMap.get("email");
        if (emailValue != null && emailValue.toUpperCase().equals("RANDOM")) {
            emailValue = DataGeneratorManager.getRandomEmail();
        }
        String passwordValue = userDetailMap.get("password");
        if (passwordValue != null && passwordValue.toUpperCase().equals("RANDOM")) {
            passwordValue = DataGeneratorManager.getRandomPassword();
        }
        registerPage.completeRegisterForm(firstNameValue, lastNameValue, emailValue, passwordValue);
    }
}
