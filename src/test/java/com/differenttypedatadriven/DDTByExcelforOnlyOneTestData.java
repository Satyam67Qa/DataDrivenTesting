package com.differenttypedatadriven;

import com.excel.utility.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DDTByExcelforOnlyOneTestData {


    public static void main(String[] args) {

        // reading or fetching data from excel code
        Xls_Reader reader = new Xls_Reader("C:/Workspace/DataDrivenTesting/src/test/java/com/TestData/ExcelFacebookReg/FacebookRegdataoneonly.xlsx");


        String firstName=reader.getCellData("RegTestData","firstname",2);
        System.out.println(firstName);
        String surName= reader.getCellData("RegTestData","surname",2);
        System.out.println(surName);
        String mobileNumber=  reader.getCellData("RegTestData","mobile",2);
        System.out.println(mobileNumber);
        String passWord=   reader.getCellData("RegTestData","password",2);
        System.out.println(passWord);

        // we are wrting the code for web app
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");

        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(firstName);

        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(surName);

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
        driver.findElement(By.name("reg_passwd__")).sendKeys(passWord);

        // driver.findElement(By.id("u_0_n_ns")).click();
        driver.quit();




    }


}
