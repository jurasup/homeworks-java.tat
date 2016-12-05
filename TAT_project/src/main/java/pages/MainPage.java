package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Represents home page Page Object Model.
 * @author Yury Suponev
 */
public class MainPage extends Page {
    private String title = "WordPressTest – Just another WordPress site";

    private MainPage() {
        this.driver = new HtmlUnitDriver();
    }

    public static MainPage goToMainPage() {
        MainPage mainPage = new MainPage();
        mainPage.driver.get(pageURL);
        return mainPage;
    }

    public LoginPage goToLogin() {
        WebElement loginLink = driver.findElement(By.xpath("//a[@href='/" + LoginPage.pageURL + "']"));
        loginLink.click();
        return new LoginPage(driver);
    }

    @Override
    public boolean isOnPage() {
        return driver.getTitle().equals(title);
    }
}
