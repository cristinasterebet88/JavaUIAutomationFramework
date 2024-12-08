package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;
    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;
    @FindBy(id = "input-email")
    private WebElement emailInput;
    @FindBy(css = "#input-password")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyToggleBar;
    @FindBy(css = "button[type='submit']")
    private WebElement continueButton;

    public void completeRegisterForm(String firstName, String lastName, String email, String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        System.out.println("The form was completed for: " + email + " and password: " + password);
    }

    public void enableOnTheToggleBar() {
        ScrollManager.ScrollToElement(privacyToggleBar);
        privacyToggleBar.click();
        System.out.println("The privacy rules were accepted");
    }

    public void clickOnTheContinueButton() {
        ScrollManager.ScrollToElement(continueButton);
        continueButton.click();
        System.out.println("The Continue button was clicked");
    }
}