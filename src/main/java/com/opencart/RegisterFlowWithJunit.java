package com.opencart;

import com.opencart.managers.DataGeneratorManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.AccountPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class RegisterFlowWithJunit {
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("The excution starts");
    }

    @BeforeEach
    public void beforeEach() {
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("User is redirected to the account page when registered with valid date")
    public void registerFlowWithValidDataRedirectsTheUserToAccountPage() throws InterruptedException {

        //Generate random data
        String firstName = DataGeneratorManager.getRandomFirstName();
        String lastName = DataGeneratorManager.getRandomLastName();
        String email = DataGeneratorManager.getRandomEmail();
        String password = DataGeneratorManager.getRandomPassword();

        //Actions on the Register page
        registerPage.completeRegisterForm(firstName, lastName, email, password);
        registerPage.enableOnTheToggleBar();
        registerPage.clickOnTheContinueButton();

        Thread.sleep(1000);
        boolean urlContainsSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainsSuccessKeyword, "The URL of the page contains the success keyword");
    }

    @Test
    @DisplayName("The user remains on the Register page when registering without accepting the terms and conditions")
    public void userRemainOnRegisterPageWhenRegisteringWithoutAcceptingPrivacyRules() throws InterruptedException {

        //Generate random data
        String firstName = DataGeneratorManager.getRandomFirstName();
        String lastName = DataGeneratorManager.getRandomLastName();
        String email = DataGeneratorManager.getRandomEmail();
        String password = DataGeneratorManager.getRandomPassword();

        //Actions on the Register page
        registerPage.completeRegisterForm(firstName, lastName, email, password);
        registerPage.clickOnTheContinueButton();

        Thread.sleep(1000);
        Assertions.assertTrue(driver.getCurrentUrl().contains("register"));
    }

    @Test
    @DisplayName("Navigate to Login page from Register page")
    public void navigateToLoginPageFromRegisterPage() {
        registerPage.navigateToLoginPage();
        Assertions.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @AfterEach
    public void afterEach() {
        DriverManager.getInstance().quitTheDriver();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("The execution of all tests is done");
    }
}