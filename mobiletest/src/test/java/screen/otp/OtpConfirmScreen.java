package screen.otp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.Wait;

public abstract class OtpConfirmScreen {


    protected final AppiumDriver driver;
    protected final Wait<AppiumDriver> wait;

    public OtpConfirmScreen(AppiumDriver driver, Wait<AppiumDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public abstract void waitForLoad();

    public abstract void enterOtp();
}
