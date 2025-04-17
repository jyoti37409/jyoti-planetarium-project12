package com.revature;

import org.openqa.selenium.WebDriver;
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
public class Main {

    public static void main(String[] args) {
        /*
            In Selenium pre version 4, you had to manually download and configure a driver in
            order to perform browser automation. Starting in version 4 this process is automated
            for you

            All browser actions are facilitated by a WebDriver object: depending on the specific
            browser you are using, you make a driver for that particular browser
         */
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            driver.get("https://www.wikipedia.org/");
        } finally {
            if(driver != null){
                driver.quit();
            }
        }



    }

}
