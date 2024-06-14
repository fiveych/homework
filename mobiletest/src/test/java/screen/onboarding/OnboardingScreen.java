package screen.onboarding;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.Wait;

public abstract class OnboardingScreen {

    protected final AppiumDriver driver;
    protected final Wait<AppiumDriver> wait;

    public OnboardingScreen(AppiumDriver driver, Wait<AppiumDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public abstract void tapSkipButton();
}
