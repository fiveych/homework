package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class PinSetupPage {

    @FindBy(xpath = "//input[@autocomplete=\"off\"]")
    private List<WebElement> fields;

    private final WebDriver driver;
    private final Wait<WebDriver> wait;

    public PinSetupPage(WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public PinSetupPage waitForLoad() {
        wait.until(driver -> fields.size() == 6);
        return this;
    }

    public void enterPin() {
        fields.forEach(field -> field.sendKeys("1"));
    }
}
