package screen.step;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.Wait;
import screen.window.IosSomeWindow;

public class IosAuthSteps extends AuthSteps {

    private IosSomeWindow iosSomeWindow;

    public IosAuthSteps(AppiumDriver driver, Wait<AppiumDriver> wait) {
        super(driver, wait);
    }

    @Override
    public void login(String login) {

        onboardingScreen
                .tapSkipButton();

        iosSomeWindow
                .someTap();

        otpConfirmScreen
                .enterOtp();
    }
}
