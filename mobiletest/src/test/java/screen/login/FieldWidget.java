package screen.login;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

public class FieldWidget extends Widget {

    @AndroidFindBy(id = "rbmk_inputViewId")
    private WebElement field;

    @AndroidFindBy(id = "text_input_end_icon")
    private WebElement clearIcon;

    protected FieldWidget(WebElement element) {
        super(element);
    }

    public void enter(String text) {
        field.sendKeys(text);
    }

    public void tapClearIcon() {
        clearIcon.click();
    }
}
