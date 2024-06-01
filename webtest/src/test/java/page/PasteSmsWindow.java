package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class PasteSmsWindow {

    public static final By PASTE_BUTTON_SELECTOR = By.className("ActionSheetButton_buttonText__stdXM");

    private final WebDriver driver;
    private final Wait<WebDriver> wait;

    public PasteSmsWindow(WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public PasteSmsWindow waitForLoad() {
        wait.until(driver -> !driver.findElements(PASTE_BUTTON_SELECTOR).isEmpty());
        return this;
    }

    public void clickPasteButton() {
        driver.findElement(PASTE_BUTTON_SELECTOR).click();
    }
}
