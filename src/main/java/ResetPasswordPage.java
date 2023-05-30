import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertTrue;

public class ResetPasswordPage {
    private SelenideElement resetPasswordElement = $x("//h6");

    public void checkResetPasswordTitle() {
        resetPasswordElement.shouldBe(visible);
        resetPasswordElement.shouldHave(text("Reset Password"));
    }

    public void getUrlOfCurrentPage() {
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("requestPasswordResetCode"));
    }
}
