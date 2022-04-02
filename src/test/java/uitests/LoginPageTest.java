package uitests;

import core.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.LoginPage2;
import static Entities.BaseClass.USERNAME;
import static Entities.BaseClass.PWD;
@Test
public class LoginPageTest extends BaseTest{


    public void test(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://github.com/");
        driver.manage().window().maximize();
        LoginPage2 loginPage = new LoginPage2(driver);
        loginPage.signInBtn.click();
        loginPage.username.sendKeys(USERNAME);
        loginPage.password.sendKeys(PWD);
        loginPage.submitBtn.click();

    }
}