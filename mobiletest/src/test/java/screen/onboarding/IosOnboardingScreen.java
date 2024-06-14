package screen.onboarding;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;

public class IosOnboardingScreen extends OnboardingScreen {

    private static final By SKIP_BUTTON_LOCATOR = AppiumBy.accessibilityId("iosSkipId");

    public IosOnboardingScreen(AppiumDriver driver, Wait<AppiumDriver> wait) {
        super(driver, wait);
    }

    @Override
    public void tapSkipButton() {
        driver.findElement(SKIP_BUTTON_LOCATOR).click();
    }
}
