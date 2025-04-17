package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
    Selenium is a browser automation tool that happens to work
    very well for our testing purposes. There are a few different
    software solutions Selenium provides, we will focus on the
    Selenium WebDriver offering

    - Selenium WebDriver: the SDK for working with Selenium
    - Selenium IDE: a browser add-on that allows for recording actions in
                    the browser and generating scripts based on
                    those actions
    - Selenium Grid: a tool for managing parallel Selenium operations
 */
public class EnglishLinkExample {

    public static void main(String[] args) {
        /*
            In Selenium pre version 4, you had to manually download and configure a driver in
            order to perform browser automation. Starting in version 4 this process is automated
            for you

            All browser actions are facilitated by a WebDriver object: depending on the specific
            browser you are using, you make a driver for that particular browser
         */

        // we have to manually close the driver, so we create the variable outside the try/finally block
        WebDriver driver = null;
        try{
            // initialize the driver with the specific browser driver you want to use
            driver = new ChromeDriver();
            // the get method opens a new page
            driver.get("https://www.wikipedia.org/");
            /*
                In order to provide Selenium with the information it needs in order to interact with
                elements in the DOM we have to use a locator strategy with element finding method.

                If you are looking for a single element the findElement method will return the first
                element in the DOM that matches your locator strategy. If no element is found an exception
                is thrown

                If you want one or more elements, or if you do not want an exception to be thrown if no
                element is found that matches your locator strategy, findElements can be used

                In either case, the By class is used to inform Selenium of what locator strategy you
                are using and what Selenium should be looking for in the DOM
             */
            WebElement englishLink = driver.findElement(By.tagName("a"));
            // here we are simply checking via the text content of the element we have the english link
            System.out.println(englishLink.getText());
            /*
                Once you have have a WebElement object you can automate basic actions with those elements.
                For instance, with the anchor element we grabbed in the code above, typically a user
                would click on the link and be sent to the English homepage of Wikipedia. We can simulate
                that action by using the click method
             */
            englishLink.click();
            System.out.println(driver.getTitle());
        } finally {
            // don't forget to quit the driver when you are finished
            if(driver != null){
                driver.quit();
            }
        }



    }

}
