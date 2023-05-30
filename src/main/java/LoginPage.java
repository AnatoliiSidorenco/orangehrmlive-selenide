import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import java.time.Duration;
import java.util.Set;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement usernameField = $(byCssSelector("[name='username']"));
    private SelenideElement passwordField = $(byAttribute("placeholder", "Password"));
    public SelenideElement loginButton = $x("//button[@type='submit']");

    private SelenideElement actualerrorMessage = $(byCssSelector("[class='oxd-text oxd-text--p oxd-alert-content-text']"));

    public SelenideElement userNameEmpty = $x("(//div[@class='oxd-form-row'])[1]");
    public SelenideElement passwordEmpty = $x("(//div[@class='oxd-form-row'])[2]");

    private SelenideElement forgotPasswordLink = $(byClassName("orangehrm-login-forgot"));

    public SelenideElement logoPictureOrange = $x("//*[@class='orangehrm-login-branding']/img");

    private SelenideElement logoUserNameAndPassword = $(byClassName("orangehrm-demo-credentials"));

    public SelenideElement linkedInIconOnLoginPage = $x("(//*[@class='oxd-icon orangehrm-sm-icon'])[1]");
    private SelenideElement linkedInPageMainWord = $x("(//*[@class='sr-only'])[1]");

    public SelenideElement faceBookIconOnLoginPage = $x("(//*[@class='oxd-icon orangehrm-sm-icon'])[2]");
    private SelenideElement faceBookPageMainWord = $x("(//*[@aria-label='Facebook']");

    public SelenideElement twitterIconOnLoginPage = $x("(//*[@class='oxd-icon orangehrm-sm-icon'])[3]");
    private SelenideElement twitterPageMainWord = $x("(//h2//div[@dir='ltr']//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'])[1]");

    //div[@aria-label="Close"]

    public void enterUsername(String usernameValue) {
        usernameField.shouldBe(visible);
        usernameField.setValue(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        passwordField.setValue(passwordValue);
    }

    public void pushLoginButton() {
        loginButton.click();
    }

    public void followTheForgotPasswordLink() {
        forgotPasswordLink.shouldBe(visible);
        forgotPasswordLink.click();
    }

    public void errorMessage(String expectedErrorMessage) {
        actualerrorMessage.shouldBe(visible, Duration.ofSeconds(10));
        actualerrorMessage.shouldHave(text(expectedErrorMessage));
    }

    public void errorMessageEmptyFieldLogin() {
        userNameEmpty.shouldBe(visible);
        userNameEmpty.shouldHave(text("Required"));
    }

    public void errorMessageEmptyFieldPassword() {
        passwordEmpty.shouldBe(visible);
        passwordEmpty.shouldHave(text("Required"));
    }

    public void checkElementsOfLoginPage() {
        logoPictureOrange.shouldBe(visible);
        logoUserNameAndPassword.shouldBe(visible);
    }

    public void logoImageIsCorrect() {
        logoPictureOrange.shouldHave(attributeMatching("src", ".*ohrm_branding.png.*"));
    }


// todo ----------------------Check Icons-------------------------------------------------------------------------
    public void clickOnLinkedInIcon() {
        linkedInIconOnLoginPage.shouldBe(visible);
        linkedInIconOnLoginPage.click();
    }
    public void switchToWindow() {
        String mainWindowHandle = WebDriverRunner.getWebDriver().getWindowHandle();
        Set<String> windowHandles = WebDriverRunner.getWebDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                WebDriverRunner.getWebDriver().switchTo().window(windowHandle);
                break;
            }
        }
        System.out.println(WebDriverRunner.getWebDriver().getWindowHandles());
    }
    public void checkLinkedInPageMainWord() {
        linkedInPageMainWord.shouldBe(visible);
        linkedInPageMainWord.shouldHave(text("LinkedIn"));
    }


    public void clickOnFaceBookIcon() {
        faceBookIconOnLoginPage.shouldBe(visible);
        faceBookIconOnLoginPage.click();
    }
    public void checkFaceBookPageMainWord() {
        faceBookPageMainWord.shouldBe(visible);
        faceBookPageMainWord.shouldHave(text("Facebook"));
    }

    public void clickOnTwitterIcon() {
        twitterIconOnLoginPage.shouldBe(visible);
        twitterIconOnLoginPage.click();
    }
    public void checkTwitterPageMainWord() {
        twitterPageMainWord.shouldBe(visible);
        twitterPageMainWord.shouldHave(text("Facebook"));
    }
}

