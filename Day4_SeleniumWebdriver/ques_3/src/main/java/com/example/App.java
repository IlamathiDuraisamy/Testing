package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.shoppersstop.com");
        driver.findElement(By.xpath("/html/body/main/header/div[1]/div/div[2]/div[2]/ul/li[4]/a/i")).click();

    }
}