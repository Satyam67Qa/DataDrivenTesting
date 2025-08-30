package com.differenttypedatadriven;

import com.excel.utility.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DDTByExcelForMultiDataOrParameter {
    public static void main(String[] args) {

        // here we are doing web driver code beacuse of multidata we define the driver code here
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");


        // code for read or featch data from Excel
        Xls_Reader reader = new Xls_Reader("C:/Workspace/DataDrivenTesting/src/test/java/com/TestData/ExcelFacebookReg/FacebookReg.xlsx");
            // get the rowcount as it is need for loop
            int  rowCount=reader.getRowCount("RegTestData");
            System.out.println(rowCount);

            // new col in the sheet
           // reader.addColumn("RegTestData","status");
            if(reader.isSheetExist("RegTestData")){
                System.out.println("sheet is present");
                reader.addColumn("RegTestData","status");
            } else if (!reader.isSheetExist("RegTestData")) {
                System.out.println("sheet is not present");
                
            }


        //loop
        for (int rowNum=2;rowNum<=rowCount;rowNum++){

            System.out.println(">>>>>>>start data <<<<<<<<<<<<<");
            String firstName=reader.getCellData("RegTestData","firstname",rowNum);
            System.out.println(firstName);
            String surName= reader.getCellData("RegTestData","surname",rowNum);
            System.out.println(surName);
            String mobileNumber=  reader.getCellData("RegTestData","mobile",rowNum);
            System.out.println(mobileNumber);
            String passWord=   reader.getCellData("RegTestData","password",rowNum);
            System.out.println(passWord);
            System.out.println(">>>>>>>end  data <<<<<<<<<<<<<");

            // driver code sending data to web app from excel using above code

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

            // set new data in the sheet
            System.out.println( reader.setCellData("RegTestData","status",rowNum,"pass"));


        }

         driver.quit();

    }
}
