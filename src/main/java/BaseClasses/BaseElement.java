package BaseClasses;


import Utilities.Browser.BrowserUtil;
import Utilities.LoggerUtil;
import Utilities.WaitsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utilities.Browser.BrowserFactory.getDriver;


public abstract class BaseElement {
    private final By uniqueLocator;
    private final String elementName;
    private static final LoggerUtil logger = LoggerUtil.getInstance();

    public BaseElement(By locator, String name) {
        this.uniqueLocator = locator;
        this.elementName = name;
    }

    protected WebElement getElement() {
        logger.logInfo("Getting of element: " + elementName);
        return getDriver().findElement(uniqueLocator);
    }

    public void click() {
        WaitsUtil.waitForElementToBeClickable(uniqueLocator);
        logger.logDebug("Clicking of " + elementName);
        getElement().click();
    }

    public void scrollToElement() {
        logger.logInfo("Scrolling to element: " + elementName);
        BrowserUtil.scroll(getElement());
    }

    public boolean isElementPresent() {
        return WaitsUtil.waitForElementPresence(uniqueLocator);
    }

}