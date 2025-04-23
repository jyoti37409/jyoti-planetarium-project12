package com.revature.step;

import com.revature.pom.AddMoonPage;
import com.revature.pom.AddPlanetPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.revature.TestRunner.*;

public class AddMoonSteps {
    @Given("the user is on the planetarium homepage and selects Moon")
    public void the_user_is_on_the_planetarium_homepage() {
        driver.get("http://localhost:8080");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login steps
        driver.findElement(By.id("usernameInput")).sendKeys("Batman");
        driver.findElement(By.id("passwordInput")).sendKeys("Iamthenight1939");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Wait for redirect to homepage
        wait.until(ExpectedConditions.urlContains("/planetarium"));

        // Wait for dropdown to be ready and select "Planet"
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("locationSelect")));
        new Select(dropdown).selectByVisibleText("Moon");

        // Now wait for the input field to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("moonNameInput")));

        // Now continue
        addPlanetPage = new AddPlanetPage(driver, "Planetarium");
        addMoonPage = new AddMoonPage(driver, "Planetarium");
        Assert.assertTrue(addPlanetPage.isWelcomeMessageDisplayed("Batman"));
    }

    @When("the user provides a valid moon name {string} and planet ID {int}")
    public void the_user_provides_a_valid_moon_name_and_planet_id(String moonName, int planetId) {
        addMoonPage.selectLocationAsMoon();
        addMoonPage.enterMoonName(moonName);
        addMoonPage.enterOrbitedPlanetId(planetId);  //  set orbited planet ID
        addMoonPage.clickButton();
    }

    @When("the user provides a valid moon name {string} and planet ID {int} and image {string}")
    public void the_user_provides_a_valid_moon_image_path(String moonName, int planetId, String path) {
        addMoonPage.selectLocationAsMoon();
        addMoonPage.enterMoonName(moonName);
        addMoonPage.enterOrbitedPlanetId(planetId);  //  set orbited planet ID
        addMoonPage.uploadMoonImage(path);
        addMoonPage.clickButton();
    }

    @Then("moon alert should appear saying {string}")
    public void moon_alert_should_appear_saying(String expectedAlertText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String actualText = alert.getText();
        System.out.println(" Alert: " + actualText);
        Assert.assertEquals(expectedAlertText, actualText);
        alert.accept();
    }


    @Then("the moon name {string} should be saved on the Planetarium Home Page")
    public void the_moon_name_should_be_saved_on_the_planetarium_home_page(String moonName) {
        try {
            System.out.println("Pausing for 5 seconds to observe the page...");
            Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
            try{
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                String alertText = alert.getText();
                System.out.println("alert present during verification " + alertText);
                alert.accept();
                Assert.fail("Test failed due to alert: " + alertText);
                return;
            }
            catch (TimeoutException ignored){
            }

            Assert.assertTrue(addMoonPage.isMoonDisplayed(moonName));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
