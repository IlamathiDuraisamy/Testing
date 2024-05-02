package com.example; 
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class qn5
{
    final Logger logger = Logger.getLogger(getClass());
    WebDriver driver;
    @BeforeMethod
    public void setup() throws InterruptedException
    {
        PropertyConfigurator.configure("C:\\Users\\Dell\\Downloads\\demo\\demo\\que 5\\qn5\\src\\main\\resources\\Log24j.properties");
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.puriholidayresort.com/");
        Thread.sleep(3000);
        logger.warn("Waits for 3 sec");
        //pop-up
        WebElement popup = driver.findElement(By.xpath("//*[@id=\"myModal_home\"]/div/div/div[1]/button"));
        popup.click();
        logger.info("Pop-up closed successfully");
    }
    @Test
    public void test1()throws InterruptedException
    {
        
        //in and out
        WebElement checkInElement = driver.findElement(By.xpath("//*[@id=\"arr_datepicker\"]"));
        checkInElement.sendKeys("20-04-2024");
        logger.info("Check-in date selected successfully");

        WebElement checkOutElement = driver.findElement(By.xpath("//*[@id=\"dep_datepicker\"]"));
        checkOutElement.sendKeys("22-04-2024");
        logger.info("Check-out date selected successfully");
        //book now
        WebElement bookNowButton = driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/form/div[2]/button"));
        bookNowButton.click();
        logger.info("Clicked on 'Book Now' button");
        //verify
        WebElement propertyInfoLabel = driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div[3]/div/div/div[1]/div"));
        if (propertyInfoLabel.isDisplayed()) {
            logger.info("'Property Information' label is present");
        } else {
            logger.error("'Property Information' label is not present");
        }
        driver.quit();
    }
    @Test
    public void test2() throws InterruptedException
    {
        WebElement roomsMenu = driver.findElement(By.xpath("//*[@id=\"cssmenu\"]/ul/li[2]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(roomsMenu).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/div[2]/div/div/div/ul/li[2]/ul/li[2]/a")).click();
        logger.info("Chose 'Royal Suite'");
        Thread.sleep(5000);
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1200)");
        WebElement amenities = driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[5]/div/section/div/h3[2]"));
        amenities.click();
        String priceLabel = driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[5]/div/section/div/p[2]")).getText();
        if (priceLabel.contains("Price")) {
            logger.info("'Price' label is present in Amenities section");
        } else {
            logger.error("'Price' label is not present in Amenities section");
        }
        driver.quit();
    }
    @Test
    public void test3() throws InterruptedException
    {
        WebElement aboutPuriMenu = driver.findElement(By.xpath("//*[@id=\"cssmenu\"]/ul/li[1]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(aboutPuriMenu).perform();
        Thread.sleep(3000);
        WebElement chilikaLakeLink = driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/div[2]/div/div/div/ul/li[1]/ul/li[7]/a"));
        chilikaLakeLink.click();
        logger.info("Selected 'Chilika Lake'");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        logger.info("Scrolled down to TripAdvisor review section");
      
       
        driver.close();
    }
}
