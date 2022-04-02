package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    void setupTest() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://github.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    void teardown() {
        driver.quit();
    }
}
