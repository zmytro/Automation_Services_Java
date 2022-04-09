package core;

import org.openqa.selenium.WebDriver;
import pom.HomePage;
import pom.LoginPage;

public class GitHub {
    private static GitHub gitHub;

    public HomePage homePage;

    public LoginPage loginPage;

    public GitHub(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
    }

    public static GitHub init(WebDriver driver){
        if(gitHub == null){
            gitHub = new GitHub(driver);
        }
        return gitHub;
    }
}
