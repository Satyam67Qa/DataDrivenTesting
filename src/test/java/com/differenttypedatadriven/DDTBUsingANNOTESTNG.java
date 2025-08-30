package com.differenttypedatadriven;

import com.excel.utility.TestUtilForDATAanno;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

public class DDTBUsingANNOTESTNG {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
    }
     @DataProvider
     public Iterator<Object[]> sendDataToTest(){
         ArrayList<Object[]> testData=TestUtilForDATAanno.getDataFromExcel();
                return testData.iterator();
     }

     @Test(dataProvider="sendDataToTest")
     public void facebookRegPageTest(String firstname,String surname,String mobileNumber, String password)
     {

         driver.findElement(By.name("firstname")).clear();
         driver.findElement(By.name("firstname")).sendKeys(firstname);

         driver.findElement(By.name("lastname")).clear();
         driver.findElement(By.name("lastname")).sendKeys(surname);

         Select select = new Select(driver.findElement(By.id("day")));
         select.selectByVisibleText("2");
         Select select1 = new Select(driver.findElement(By.id("month")));
         select1.selectByVisibleText("Jun");
         Select select2 = new Select(driver.findElement(By.id("year")));
         select2.selectByVisibleText("2019");

         WebElement genderRadiobutton=  driver.findElement(By.xpath("//input[@value=\"2\"]"));
         genderRadiobutton.click();

         driver.findElement(By.name("reg_email__")).clear();
         driver.findElement(By.name("reg_email__")).sendKeys(mobileNumber);

         driver.findElement(By.name("reg_passwd__")).click();
         driver.findElement(By.name("reg_passwd__")).sendKeys(password);}

         @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
