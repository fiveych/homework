package screen.step;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.Wait;

public class AndroidAuthSteps extends AuthSteps {

    public AndroidAuthSteps(AppiumDriver driver, Wait<AppiumDriver> wait) {
        super(driver, wait);
    }

    @Override
    public void login(String login) {

        onboardingScreen
                .tapSkipButton();

        welcomeScreen
                .tapLoginButton();

        loginScreen
                .tapLoginTab()
                .enterText(login)
                .tapContinueButton();

        otpConfirmScreen
                .waitForLoad();

        otpConfirmScreen
                .enterOtp();
    }
}
