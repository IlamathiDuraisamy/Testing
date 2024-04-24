package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

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
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://www.firefox.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bing.com");
    }
}