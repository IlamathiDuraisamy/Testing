package com.example;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class CE_1 {

    @Test(dataProvider="dat")
    public void test1(String username, String password)
    {  
        WebDriverManager.chromedriver().setup();
          WebDriver driver=new ChromeDriver();
          driver.manage().window().maximize();
          driver.get("http://dbankdemo.com/bank/login");
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
          driver.findElement(By.xpath("//*[@name='username']")).sendKeys(username);
          driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
          driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/button")).click(); 
        }

    @DataProvider(name ="dat")
    public Object[][] fetchData() throws IOException
    {
        Object[][] data=new Object[2][2];
        data[0][0] = "S@gmail.com";
        data[0][1] = "P@ssword12";
        return data;
    }

    }

