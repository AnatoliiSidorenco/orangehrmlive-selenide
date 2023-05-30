import org.junit.Test;

import static java.lang.Thread.sleep;

public class LoginTest extends BaseTest {

    @Test
    public void successLogin() {
      /*  open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        sleep(3000);
        LoginPage loginPage = new LoginPage();*/
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.pushLoginButton(); //$(byXpath("//button[@type='submit']"))
        // DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.correctHeader();
    }

    @Test
    public void invalidPassword() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin12");
        loginPage.pushLoginButton();
        loginPage.errorMessage("Invalid credentials");
    }

    @Test
    public void emptyFields() {
        loginPage.pushLoginButton();
        loginPage.errorMessageEmptyFieldLogin();
        loginPage.errorMessageEmptyFieldPassword();
    }

    @Test
    public void emptyFields1() {

        loginPage.enterPassword("admin123");
        loginPage.pushLoginButton();
        loginPage.errorMessageEmptyFieldLogin();
    }

    @Test
    public void emptyFields2() {
        loginPage.enterUsername("Admin");
        loginPage.pushLoginButton();
        loginPage.errorMessageEmptyFieldPassword();
    }

    @Test
    public void forgotPassword() {
        loginPage.followTheForgotPasswordLink();
        resetPasswordPage.checkResetPasswordTitle();
        resetPasswordPage.getUrlOfCurrentPage();
    }

    @Test
    public void elementsAreVisible() {
        loginPage.checkElementsOfLoginPage();
        loginPage.logoImageIsCorrect();
    }

    @Test
    public void comparisonLinkedIn() {
        loginPage.clickOnLinkedInIcon();
        loginPage.switchToWindow();
        loginPage.checkLinkedInPageMainWord();
    }
    @Test
    public void comparisonFaceBook() throws InterruptedException {
        loginPage.clickOnFaceBookIcon();
        loginPage.switchToWindow();
        sleep(1000);
        loginPage.checkFaceBookPageMainWord();
    }

    @Test
    public void comparisonTwitter() {
        loginPage.clickOnTwitterIcon();
        loginPage.switchToWindow();
        loginPage.checkTwitterPageMainWord();
    }
}
