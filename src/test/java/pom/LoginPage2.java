package pom;

import core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

public class LoginPage2 extends AbstractPOM {
    public LoginPage2(WebDriver driver) {
        super(driver);
    }
        @FindBy(partialLinkText = "Sign")
        public WebElement signInBtn;

        @FindBy(xpath = "//input[@type='submit']")
        public WebElement submitBtn;

        @FindBy(name = "login")
            public WebElement username;

        @FindBy(id = "password")
        public WebElement password;
    }

