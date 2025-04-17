package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchFunctionalityExample {
    public static void main(String[] args) {

        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            driver.get("https://www.wikipedia.org/");
            WebElement searchBar = driver.findElement(By.id("searchInput"));
            // anytime you want to enter a value into an input you can use sendKeys
            searchBar.sendKeys("puppy");
            WebElement searchButton = driver.findElement(By.className("pure-button-primary-progressive"));
            searchButton.click();
            System.out.println(driver.getTitle());
            driver.get("https://www.wikipedia.org/");
            /*
                At this point in the code we are going to run into an issue with "Stale" elements.
                Selenium does not just locate elements when we use findElement, it also tracks the state
                of the page. When the state of the page changes (like new content is loaded, page changes, etc)
                all previous element references become "stale". The selector we used to find the element may
                still be valid, but because the state of the page has changed Selenium can not be certain that
                the reference is still valid, so an exception is thrown if we try to use the stale element

                In order to prevent the need of developers to constantly recreate object references to stale
                elements Selenium provides a tool called the PageFactory that can handle this for us. A common
                design pattern that utilizes the PageFactory is called the Page Object Model (POM for short)
             */
            searchBar.sendKeys("apple");
            searchButton.click();
            System.out.println(driver.getTitle());

        } finally {
            if(driver != null){
                driver.quit();
            }
        }


    }
}
