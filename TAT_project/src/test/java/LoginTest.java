import database.DatabaseWorker;
import database.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

import static org.testng.Assert.assertTrue;

/**
 * Tests for login page.
 * @author Yury Suponev
 */
public class LoginTest {
    private DatabaseWorker worker = new DatabaseWorker();
    private User user;

    @BeforeClass
    public void setUp() throws Exception {
        User.UserBuilder builder = User.newBuilder();
        user = builder.build(User.UserBuilder.SUBSCRIBER);
        worker = new DatabaseWorker();
        worker.addUser(user);
    }

    @AfterClass
    public void tearDown() {
        worker.deleteUser(user.getID());
    }

    @Test
    public void positiveValidLogin() {
        LoginPage loginPage = LoginPage.goToLoginPage();
        ProfilePage profilePage = loginPage.loginAs(user.getLogin(), user.getPassword());
        assertTrue(profilePage.isOnPage());
    }
}
