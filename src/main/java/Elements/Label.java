package Elements;

import BaseClasses.BaseElement;
import Utilities.LoggerUtil;
import org.openqa.selenium.By;

public class Label extends BaseElement {
    private static final LoggerUtil logger = LoggerUtil.getInstance();

    public Label(By locator, String name) {
        super(locator, name);
    }

    public String getText() {
        String text = getElement().getText();
        logger.logDebug("Text of label: " + text);
        return text;
    }
}