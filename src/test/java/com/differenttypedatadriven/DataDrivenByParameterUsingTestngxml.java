package com.differenttypedatadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDrivenByParameterUsingTestngxml {
    WebDriver driver;

    @Test
    @Parameters({"env","browser","url","email","pass"})
    public void yahooTest( String env,String browser,String url,String email,String pass )
    {
        if (browser.equals("chrome"))
        {
            driver= new ChromeDriver();
            driver.get(url);
        } else
        if (browser.equals("firefox"))
        {
            driver= new FirefoxDriver();
            driver.get(url);
        }
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(pass);
        //driver.findElement(By.id("loginbutton")).click();
        driver.quit();



    }


}
