package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class LoginPage {

    private static final By FIELD_LOCATOR = By.id("login");
    private static final By CONTINUE_BUTTON_LOCATOR = By.tagName("button");

    private final WebDriver driver;
    private final Wait<WebDriver> wait;

    public LoginPage(WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public LoginPage waitForLoad() {
        wait.until(driver -> driver.findElements(FIELD_LOCATOR).size() == 1);
        return this;
    }

    public LoginPage enterLogin(String login) {
        getField().sendKeys(login);
        return this;
    }

    private WebElement getField() {
        return driver.findElement(FIELD_LOCATOR);
    }

    public LoginPage waitForContinueButtonToEnabled() {
        wait.until(ExpectedConditions.elementToBeClickable(CONTINUE_BUTTON_LOCATOR));
        return this;
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    private WebElement getContinueButton() {
        return driver.findElement(CONTINUE_BUTTON_LOCATOR);
    }

    private Field getFieldComponent() {
        return new Field(driver, By.className("InputOrdinaryStyle_inputWrapper__k+6Qh InputOrdinaryStyle_desktop__TJe+Z"));
    }
}
