import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import screen.step.AndroidAuthSteps;
import screen.step.AuthSteps;
import screen.step.IosAuthSteps;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SomeTest {

    private static final String APP_PACKAGE = "";
    private static final String APP_ACTIVITY = "";

    private AppiumDriver driver;

    private AuthSteps authSteps;

    @BeforeEach
    void setUp() {

        URL url;
        try {
            url = new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        UiAutomator2Options options = new UiAutomator2Options()
                .autoGrantPermissions()
                .enforceAppInstall()
                .setAppPackage(APP_PACKAGE)
                .setAppActivity(APP_ACTIVITY);

        driver = new AndroidDriver(url, options);

        final int timeout = 10;
        Wait<AppiumDriver> wait = new FluentWait<>(driver)
                .ignoring(NoSuchElementException.class)
                .withTimeout(Duration.ofSeconds(timeout));

        authSteps = driver.getClass() == AndroidDriver.class
                ? new AndroidAuthSteps(driver, wait)
                : new IosAuthSteps(driver, wait);
    }

    @Test
    void test() {

        final String login = "5test09876";
        authSteps
                .login(login);
    }

    @AfterEach
    void tearDown() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
