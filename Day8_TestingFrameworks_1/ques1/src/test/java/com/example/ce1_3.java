package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.time.Duration;

public class ce1_3
{
    @Test(dataProvider="dat")
    public void test1(String username, String password) throws InterruptedException
    {  
        WebDriverManager.chromedriver().setup();
          WebDriver driver=new ChromeDriver();
          driver.manage().window().maximize();
          driver.get("http://dbankdemo.com/bank/login");
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
          driver.findElement(By.xpath("//*[@name='username']")).sendKeys(username);
          driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
          driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/button")).click(); 
          driver.findElement(By.xpath("/html/body/aside/nav/div[2]/ul/li[6]/a")).click(); 
          driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[1]/div[2]/div/div/select")).click(); 
          driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[1]/div[2]/div/div/select/option[3]")).click();
          WebElement textbox=driver.findElement(By.xpath("//*[@id='amount']"));
          textbox.sendKeys("3000"+Keys.ENTER);
          driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[2]/button[1]")).click(); 
          Thread.sleep(3000);
        }

    @DataProvider(name ="dat")
    public Object[][] fetchData() throws IOException
    {
        Object[][] data=new Object[2][2];
        data[0][0] = "S@gmail.com";
        data[0][1] = "P@ssword12";
        data[1][0] = "P@gmail.com";
        data[1][1] = "P@ssword12";
        return data;
    }

    }

