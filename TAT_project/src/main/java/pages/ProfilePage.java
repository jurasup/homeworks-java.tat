package pages;

import org.openqa.selenium.WebDriver;

/**
 * Represents profile page Page Object Model.
 * @author Yury Suponev
 */
public class ProfilePage extends Page {
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        pageURL = super.pageURL.concat("wp-admin/profile.php");
        if(!driver.getTitle().contains("Profile")) {
            throw new IllegalStateException("Not on profile page.");
        }
    }
}
