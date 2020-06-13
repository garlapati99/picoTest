package com.ocbc.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestSelenium {

    private WebDriver driver;

    @BeforeTest
    public void init(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void launchBrowser() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        TimeUnit.SECONDS.sleep(5);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


}
