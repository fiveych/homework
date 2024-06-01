package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import page.LoginPage;
import page.PasteSmsWindow;
import page.PinSetupPage;

import java.time.Duration;

public class SomeTest {

    private static final String URL = "https://web-cert.evo.rosbank.ru";
    private static final String LOGIN = "503818678";
    private static final int TIMEOUT = 10;

    private WebDriver driver;

    private LoginPage loginPage;
    private PasteSmsWindow pasteSmsWindow;
    private PinSetupPage pinSetupPage;

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver(new ChromeOptions());

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .ignoring(StaleElementReferenceException.class)
                .withTimeout(Duration.ofSeconds(TIMEOUT));

        loginPage = new LoginPage(driver, wait);
        pasteSmsWindow = new PasteSmsWindow(driver, wait);
        pinSetupPage = new PinSetupPage(driver, wait);
    }

    @Test
    void test() {

        driver.get(URL);

        loginPage
                .waitForLoad()
                .enterLogin(LOGIN)
                .waitForContinueButtonToEnabled()
                .clickContinueButton();

        pasteSmsWindow
                .waitForLoad()
                .clickPasteButton();

        pinSetupPage
                .waitForLoad()
                .enterPin();

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
