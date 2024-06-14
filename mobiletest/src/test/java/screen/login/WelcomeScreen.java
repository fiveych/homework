package screen.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WelcomeScreen {

    @AndroidFindBy(id = "logInActionId")
    @iOSXCUITFindBy(id = "iosLogin")
    private WebElement loginButton;

    public WelcomeScreen(AppiumDriver driver, Wait<AppiumDriver> wait) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public void tapLoginButton() {
        loginButton.click();
    }
}
