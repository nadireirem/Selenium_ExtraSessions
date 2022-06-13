package com.cydeo.tests.officeHours.day04;

import com.cydeo.tests.officeHours.utilities.WebDriverFactory;
import org.apache.commons.lang3.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task_IQ {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
    //    1. Navigate to: https://moneygaming.qa.gameaccount.com/
        WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://moneygaming.qa.gameaccount.com/");



    }

    @Test
    public void Test(){
        //            2. Click the JOIN NOW button to open the registration page
        WebElement joinBtn=driver.findElement(By.xpath("//a[@class='newUser green']"));
        joinBtn.click();


        //        3. Select a title value from the dropdown
      Select titleDropdown=new Select(driver.findElement(By.xpath("//select[@class='title required']")));

        titleDropdown.selectByValue("Ms");



        //        4. Enter your first name and surname in the form
        WebElement firstName=driver.findElement(By.xpath("//input[@name='map(firstName)']"));
        firstName.sendKeys("Ayse");

        WebElement surname=driver.findElement(By.xpath("//input[@name='map(lastName)']"));
        surname.sendKeys("Ates");


        //        5. Check the tickbox with text "I accept the Terms and Conditions and certify that I am over the age of 18.
        WebElement checkBox=driver.findElement(By.id("checkbox"));
        checkBox.click();

        //            6. Submit the form by clicking the JOIN NOW button
WebElement joinNowBtn=driver.findElement(By.id("form"));
joinNowBtn.click();


        //        7. Validate that a validation message with text "This field is required" appears under the date of birth box
WebElement errorMsg=driver.findElement(By.xpath("//label[@for='dob']"));
        System.out.println("errorMsg.getText() = " + errorMsg.getText());

        driver.quit();

    }





}
