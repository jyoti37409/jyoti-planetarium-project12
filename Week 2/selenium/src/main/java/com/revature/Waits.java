package com.revature;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
    Selenium can get ahead of your web page and throw exceptions saying that something is wrong with
    your page, when the reality is that Selenium just needed to pause execution for a moment while
    waiting for the page to catch up. This can be due to poor latency, dynamic content generation, etc.
    Selenium offers two primary ways of telling it to pause execution: implicit and explicit waits (technically
    there is a third wait type called fluent wait, but we will focus on the first two for now)
 */
public class Waits {

    public static void main(String[] args) {

        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            /*
                Implicit waits are how you configure how long Selenium will wait for an element to be
                located before throwing an ElementNotFoundException. To get to the implicit wait configuration
                you call a chain of methods. In the example below the driver is configured to wait up to
                1 second before throwing an element not found exception
             */
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));


            driver.get("C:\\Users\\EricSuminski\\Desktop\\250704-JWA\\Week 2\\selenium\\src\\main\\resources\\Examples.html");
            WebElement header = driver.findElement(By.tagName("h1"));
            WebElement paragraph = driver.findElement(By.tagName("p"));
            System.out.println(header.getText());
            System.out.println(paragraph.getText());

            /*
                For one-off situations, or when you are waiting for something specific to happen, you
                can use an explicit wait to tell Selenium to pause execution until some condition is
                met
             */
            driver.findElement(By.tagName("button")).click();
            /*
                Alerts can be difficult to work with: sometimes Selenium will try to access them
                before they exist, so setting an explicit wait telling Selenium to pause until the
                alert is present can help to avoid flakey execution. To manage explicit waits you
                use a WebDriverWait object
             */
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            /*
                To specify what you are waiting for you can use the ExpectedConditions utility class
                which comes with a collection of pre-defined wait conditions. The example below tells
                Selenium to wait up to 2 seconds for an alert to be present
             */
            wait.until(ExpectedConditions.alertIsPresent());
            // to handle alerts you have to switch the driver over to them
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            // this simulates clicking the accept button
            alert.accept();


        } finally {
            if(driver != null) driver.quit();
        }
    }

}
