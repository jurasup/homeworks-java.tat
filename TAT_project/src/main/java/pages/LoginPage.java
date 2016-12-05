package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Represents login page Page Object Model.
 * @author Yury Suponev
 */
public class LoginPage extends Page {
    By usernameLocator = By.id("user_login");
    By passwordLocator = By.id("user_pass");
    By loginButtonLocator = By.id("wp-submit");
    By loginErrorLocator = By.id("login_error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        pageURL = super.pageURL.concat("wp-login.php");
        if(!driver.getTitle().contains("Log In")) {
            throw new IllegalStateException("Not on login page.");
        }
    }

    private LoginPage() {
        this.driver = new HtmlUnitDriver();
    }

    public static LoginPage goToLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.driver.get(pageURL);
        return loginPage;
    }

    public LoginPage enterUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public ProfilePage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new ProfilePage(driver);

    }

    public LoginPage submitLoginExpectingFailure() {
        driver.findElement(loginButtonLocator).submit();
        return new LoginPage(driver);
    }

    public ProfilePage loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        return submitLogin();
    }

    public boolean isLoginFailed() {
        if (driver.findElements(loginErrorLocator).size() != 0) {
            return true;
        } else {
            return false;
        }
    }
}
