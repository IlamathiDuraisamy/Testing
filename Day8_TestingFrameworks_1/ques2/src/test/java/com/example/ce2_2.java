package com.example;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class ce2_2
{
    @Test(dataProvider="dat")
    public void test1(String username, String password) 
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Log in")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='loginusername']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='loginpassword']")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();
    }

    @DataProvider(name ="dat")
    public Object[][] fetchData() throws IOException
    {
        Object[][] data=new Object[2][2];
        data[0][0] = "Testalpha";
        data[0][1] = "Test@123"; 
        return data;
    }
}