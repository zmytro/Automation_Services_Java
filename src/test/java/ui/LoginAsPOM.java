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
import pom.LoginPage;

public class LoginAsPOM extends BaseClass {
    WebDriver driver;
    LoginPage loginPage;

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

        loginPage = new LoginPage(driver);

        //open github page
        driver.get("https://github.com/");
        //driver.manage().window().maximize();

        //click on SignIn
        //driver.findElement(loginPage.signIn).click();
        //loginPage.login(USERNAME,PWD);


        WebElement otp = driver.findElement(By.xpath("//input[@name='otp']"));
        Assert.assertEquals(otp.getAttribute("placeholder"),"6-digit code");



    }
}
