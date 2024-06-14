package screen.otp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class IosOtpConfirmScreen extends OtpConfirmScreen {

    private static final By OTP_FIELD_LOCATOR = By.className("XCUIElementTypeField");

    public IosOtpConfirmScreen(AppiumDriver driver, Wait<AppiumDriver> wait) {
        super(driver, wait);
    }

    @Override
    public void waitForLoad() {

    }

    @Override
    public void enterOtp() {
        WebElement field = driver.findElement(OTP_FIELD_LOCATOR);
        field.sendKeys();
    }
}
