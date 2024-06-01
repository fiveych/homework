package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Field {

    private static final String FIELD_LOCATOR = null;
    private static final String PLACEHOLDER_LOCATOR = null;
    private static final String TITLE_LOCATOR = null;

    private final WebDriver driver;
    private final By by;

    public Field(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
    }
}
