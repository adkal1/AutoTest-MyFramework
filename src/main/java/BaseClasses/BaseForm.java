package BaseClasses;


import Utilities.LoggerUtil;
import Utilities.WaitsUtil;
import org.openqa.selenium.By;



public abstract class BaseForm {
    private final By uniqueFormLocator;
    private final String formName;
    private static final LoggerUtil logger = LoggerUtil.getInstance();

    public BaseForm(By locator, String name) {
        this.uniqueFormLocator = locator;
        this.formName = name;
    }

    public boolean isFormOpen() {
        logger.logInfo("Open  " + formName);
        return WaitsUtil.waitForElementPresence(uniqueFormLocator);
    }

}