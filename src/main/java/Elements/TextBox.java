package Elements;

import BaseClasses.BaseElement;
import Utilities.LoggerUtil;
import org.openqa.selenium.By;

public class TextBox extends BaseElement {
    private static final LoggerUtil logger = LoggerUtil.getInstance();

    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void setText(String value) {
        logger.logDebug("Setting value " + value);
        getElement().sendKeys(value);
    }

    public void clear() {
        getElement().clear();
        logger.logDebug("Clearing value");
    }
}