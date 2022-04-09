package pom;

import core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPOM {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(partialLinkText = "Sign up")
    public WebElement signUpBtn;
}
