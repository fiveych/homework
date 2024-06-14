package screen.onboarding;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.Wait;

public class OnboardingScreenFactory {

    public static OnboardingScreen create(AppiumDriver driver, Wait<AppiumDriver> wait) {

        return driver.getClass() == AndroidDriver.class
                ? new AndroidOnboardingScreen(driver, wait)
                : new IosOnboardingScreen(driver, wait);
    }
}
