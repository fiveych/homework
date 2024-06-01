package page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SelenideLoginPage {

    public SelenideLoginPage waitForLoad() {
        $("#login").shouldBe(visible);
        return this;
    }

    public SelenideLoginPage enterLogin(String login) {
        $("#login").setValue(login);
        return this;
    }

    public SelenideLoginPage waitForContinueButtonToEnabled() {
        $(By.tagName("button")).shouldBe(enabled);
        return this;
    }

    public void clickContinueButton() {
        $(By.tagName("button")).click();
    }
}
