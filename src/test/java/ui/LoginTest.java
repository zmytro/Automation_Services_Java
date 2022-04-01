package ui;

import Entities.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
    WebDriver driver;

    @BeforeTest
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterClass
    void teardown() {
        driver.quit();
    }

    @Test
    public void testGitHubLoginSuccess() throws InterruptedException {

        //open github page
        driver.get("https://github.com/");
        //driver.manage().window().maximize();

        //click on SignIn
        driver.findElement(By.partialLinkText("Sign in")).click();

        //Thread.sleep(100000);

        //Enter username
        driver.findElement(By.id("login_field")).clear();
        driver.findElement(By.id("login_field")).sendKeys(USERNAME);

        //Enter pwd
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.name("password")).sendKeys(PWD);

        //login btn click
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //find text after login
        WebElement repos = driver.findElement(By.xpath("//h2[contains(text(),'Repositories')]"));
        Assert.assertTrue(repos.isDisplayed());

        WebElement otp = driver.findElement(By.xpath("//input[@name='otp']"));
        Assert.assertEquals(otp.getAttribute("placeholder"),"6-digit code");



    }

}
