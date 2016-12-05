import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.Assert.assertTrue;

/**
 * Tests for main page.
 * @author Yury Suponev
 */
public class MainPageTest {

    @Test
    public void openHomePageTest() {
        MainPage mainPage = MainPage.goToMainPage();
        assertTrue(mainPage.isOnPage());
    }
}
