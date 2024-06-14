package screen.step;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.Wait;
import screen.login.LoginScreen;
import screen.login.WelcomeScreen;
import screen.onboarding.OnboardingScreen;
import screen.onboarding.OnboardingScreenFactory;
import screen.otp.AndroidOtpConfirmScreen;
import screen.otp.IosOtpConfirmScreen;
import screen.otp.OtpConfirmScreen;

public abstract class AuthSteps {

    protected final AppiumDriver driver;
    protected final Wait<AppiumDriver> wait;

    protected OnboardingScreen onboardingScreen;
    protected WelcomeScreen welcomeScreen;
    protected LoginScreen loginScreen;
    protected OtpConfirmScreen otpConfirmScreen;

    public AuthSteps(AppiumDriver driver, Wait<AppiumDriver> wait) {

        onboardingScreen = OnboardingScreenFactory.create(driver, wait);
        welcomeScreen = new WelcomeScreen(driver, wait);
        loginScreen = new LoginScreen(driver, wait);
        otpConfirmScreen = driver.getClass() == AndroidDriver.class
                ? new AndroidOtpConfirmScreen(driver, wait)
                : new IosOtpConfirmScreen(driver, wait);

        this.driver = driver;
        this.wait = wait;
    }

    public abstract void login(String login);
}
