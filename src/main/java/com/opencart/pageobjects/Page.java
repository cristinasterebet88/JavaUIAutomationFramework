package com.opencart.pageobjects;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    WebDriver driver = DriverManager.getInstance().getDriver();

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[normalize-space()='My Account'])[1]")
    protected WebElement myAccountButton;

    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Register']")
    protected WebElement registerButton;

    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Login']")
    protected WebElement loginButton;

    public void navigateToRegisterPage() {
        myAccountButton.click();
        System.out.println("My Account button was clicked");
        registerButton.click();
        System.out.println("Register button was clicked");
    }

    public void navigateToLoginPage() {
        myAccountButton.click();
        System.out.println("My Account button was clicked");
        loginButton.click();
        System.out.println("Login button was clicked");
    }
}