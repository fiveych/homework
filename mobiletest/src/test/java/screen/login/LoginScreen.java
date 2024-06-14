package screen.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class LoginScreen {

    @AndroidFindBy(id = "selectorId")
    @AndroidFindBy(className = "android.widget.TextView")
    private List<WebElement> tabs;

    @AndroidFindBy(id = "inputId")
    private FieldWidget fieldWidget;

    @AndroidFindBy(id = "nextActionId")
    private WebElement continueButton;

    public LoginScreen(AppiumDriver driver, Wait<AppiumDriver> wait) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public LoginScreen tapLoginTab() {
        final int index = 1;
        tabs.get(index).click();
        return this;
    }

    public LoginScreen enterText(String text) {
        fieldWidget.enter(text);
        return this;
    }

    public void tapContinueButton() {
        continueButton.click();
    }
}
