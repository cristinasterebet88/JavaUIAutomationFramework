package com.opencart.stepdefinitions;

import com.opencart.managers.DataGeneratorManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

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

        //Actions on the Register page
        registerPage.completeRegisterForm(firstName, lastName, email, password);
    }

    @And("the privacyPolicyToggle is enabled")
    public void thePrivacyPolicyToggleIsEnabled() throws InterruptedException {
        registerPage.enableOnTheToggleBar();
    }

    @And("continueButton is clicked")
    public void continueButtonIsClicked() throws InterruptedException {
        registerPage.clickOnTheContinueButton();
    }
}
