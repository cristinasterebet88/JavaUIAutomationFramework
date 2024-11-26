package com.opencart;

import com.opencart.managers.DataGeneratorManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.AccountPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TestRunnerWithPageObjects {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");

        HomePage homePage = new HomePage(driver);

        homePage.navigateToRegisterPage();

        //Generate random data
        String firstName = DataGeneratorManager.getRandomFirstName();
        String lastName = DataGeneratorManager.getRandomLastName();
        String email = DataGeneratorManager.getRandomEmail();
        String password = DataGeneratorManager.getRandomPassword();

        //Actions on the Register page
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.completeRegisterForm(firstName, lastName, email, password);
        registerPage.enableOnTheToggleBar();
        registerPage.clickOnTheContinueButton();

        Thread.sleep(5000);

        //Account related actions
        AccountPage accountPage = new AccountPage(driver);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
        accountPage.logOutFromTheAccount();

        homePage.navigateToLoginPage();
        Thread.sleep(5000);

        //Login page related actions
        LoginPage loginPage = new LoginPage(driver);
        loginPage.completeLoginForm(email, password);
        loginPage.clickTheLoginBtn();

        Thread.sleep(5000);

        driver.quit();
        System.out.println("The test is finished and the driver is closed");
    }
}