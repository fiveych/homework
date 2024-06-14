package screen.otp;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class AndroidOtpConfirmScreen extends OtpConfirmScreen {

    private static final By OTP_FIELDS_LOCATOR = AppiumBy.id("editTextContainer");
    private static final By OTP_HINT_LOCATOR = AppiumBy.id("debugOtpViewId");

    private final Wait<AppiumDriver> wait;

    public AndroidOtpConfirmScreen(AppiumDriver driver, Wait<AppiumDriver> wait) {
        super(driver, wait);
        this.wait = wait;
    }

    public void waitForLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(OTP_FIELDS_LOCATOR));
    }

    @Override
    public void enterOtp() {

        String otp = driver.findElement(OTP_HINT_LOCATOR).getText();
        String[] otpArray = otp.split("");

        List<WebElement> fields = driver
                .findElement(OTP_FIELDS_LOCATOR)
                .findElements(AppiumBy.className("android.widget.EditText"));

        for (int index = 0; index < fields.size(); index++) {
            fields.get(index).sendKeys(otpArray[index]);
        }
    }
}
