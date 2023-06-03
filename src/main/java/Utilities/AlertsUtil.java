package Utilities;

import Datas.RandomText;
import Utilities.Browser.BrowserFactory;
import org.openqa.selenium.NoAlertPresentException;

import java.util.Objects;



public class AlertsUtil {
    private static final String RANDOM_TEXT = RandomText.getRandomText();
    private static final LoggerUtil logger = LoggerUtil.getInstance();

    public static boolean isAlertPresent() {
        try {
            BrowserFactory.getDriver().switchTo().alert();
            logger.logInfo("Alert is present");
            return true;
        }
        catch (NoAlertPresentException Ex) {
            logger.logError("Alert isn't present");
            return false;
        }
    }
    public static void clickOkAlertPresent() {
        BrowserFactory.getDriver().switchTo().alert().accept();
    }
    public static String getAlertText() {
        return BrowserFactory.getDriver().switchTo().alert().getText();
    }
    public static String getRandomText() {
        return RANDOM_TEXT;
    }
    public static void setAlertText() {
        BrowserFactory.getDriver().switchTo().alert().sendKeys(RANDOM_TEXT);
    }
    public static boolean isTrueAssertText(String textAlert) {
        return Objects.equals(getAlertText(), textAlert);
    }

}
