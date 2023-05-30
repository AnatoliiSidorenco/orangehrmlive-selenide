import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement header = $(byCssSelector("[class='oxd-topbar-header-breadcrumb'] h6"));

    public void correctHeader() {
        header.shouldBe(visible);
        header.shouldHave(text("Dashboard"));
    }
}
