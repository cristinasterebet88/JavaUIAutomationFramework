package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the new page url contains {string} keyword")
    public void theNewPageUrlContainsKeyword(String collectKeyword) throws InterruptedException {
        Thread.sleep(2000);
        boolean containsKeyword = driver.getCurrentUrl().contains(collectKeyword);
        Assertions.assertTrue(containsKeyword, "The url contains: " + collectKeyword);
    }

    @Given("The {string} is accessed")
    public void theIsAccessed(String collectedLink) {
        driver.get(collectedLink);
        System.out.println("The accessed link is: " + collectedLink);
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
}