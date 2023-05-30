import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()); // добавить скриншот
        open(BASE_URL); // selenide.open
    }
    @After
    public void tearDown(){
        closeWebDriver();
    }
    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();


}
