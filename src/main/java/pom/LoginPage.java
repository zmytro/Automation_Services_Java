package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public By signIn = By.partialLinkText("Sign in");
    public By username = By.name("login");
    public By password = By.id("password");
    public By submit = By.xpath("//input[@type='submit']");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String username, String password){
        driver.findElement(this.username).clear();
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).clear();
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(submit).click();
    }
}
