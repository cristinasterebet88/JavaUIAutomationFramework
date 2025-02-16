package com.opencart.stepdefinitions;

import com.opencart.managers.ConfigReaderManager;
import com.opencart.managers.DriverManager;
import com.opencart.managers.ScrollManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the new page url contains {string} keyword")
    public void theNewPageUrlContainsKeyword(String collectKeyword) throws InterruptedException {
        Thread.sleep(2000);
        boolean containsKeyword = driver.getCurrentUrl().contains(collectKeyword);
        Assertions.assertTrue(containsKeyword, "The url contains: " + collectKeyword);
    }

    @Given("The {string} endpoint is accessed")
    public void theIsAccessed(String endpoint) {
        String FullLink = ConfigReaderManager.getProperty("baseUrl") + endpoint;
        driver.get(FullLink);
        System.out.println("The accessed link is: " + FullLink);
    }

    @And("a thread sleep {int} seconds is executed")
    public void aThreadSleepSecondsIsExecuted(int timeToSleep) {
        try {
            Thread.sleep(timeToSleep * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the following list of error messages is displayed:")
    public void theFollowingListOfErrorMessagesIsDisplayed(List<String> listOfErrors) throws InterruptedException {
        Thread.sleep(5000);
        listOfErrors.forEach(errorMessage -> {
            boolean messageIsDisplayed = driver.findElement(By.xpath(".//*[contains(text(),'" +
                    errorMessage + "')]")).isDisplayed();
            Assertions.assertTrue(messageIsDisplayed, "The error message is displayed");
        });
    }

    //Click-ul este facut de catre java reflection prin intermediului pasului generic din GebericSteps, nu mai este nevoie de metode pentru a face click
    @When("the {string} from {string} is clicked")
    public void theFromIsClicked(String clickableElement, String pageName) throws Exception {
        Class classInstance = Class.forName("com.opencart.pageobjects."+ pageName);
        Field webClickableElementField = classInstance.getDeclaredField(clickableElement);
        webClickableElementField.setAccessible(true);
        //castare fortata, transformam rezultatul acestei metode intr-un web element
        WebElement webClickableElement = (WebElement) webClickableElementField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
        ScrollManager.ScrollToElement(webClickableElement);
        webClickableElement.click();
    }
}