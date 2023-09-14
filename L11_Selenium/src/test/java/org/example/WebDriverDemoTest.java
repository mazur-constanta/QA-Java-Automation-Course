package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class WebDriverDemoTest {
    @Test
    public void initDriver() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "/Users/cmazur/QA Java Automation Course/L11_Selenium/src/main/resources/chromedriver");

//        WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        driver.get("https://webdriveruniversity.com/");
        driver.navigate().to("https://webdriveruniversity.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        WebElement contactButton = driver.findElement(By.xpath("//h1[contains(text(), 'CONTACT US')]"));

//        WebElement partButton = driver.findElement(By.partialLinkText("Cypress with Cucumber BDD - Beginner to Expert in 9 Hours!"));

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='section-title']//h1"));

        elements.stream()
            .map(WebElement::getText)
            .toList()
            .forEach(System.out::println);

        contactButton.click();
//        partButton.click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
//        driver.quit();
        driver.close();
    }
}
