package pages;

import org.openqa.selenium.WebDriver;

/**
 * Represent abstract Page Object Model.
 * @author Yury Suponev
 */
public abstract class Page {
    protected WebDriver driver;
    protected static String pageURL = "http://localhost:8888/";

    /**
     * Verifies if this page is current.
     */
    public boolean isOnPage() {
        return driver.getCurrentUrl().equals(pageURL);
    }
}
