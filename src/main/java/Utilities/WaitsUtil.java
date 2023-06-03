package Utilities;

import Utilities.Browser.BrowserFactory;
import Datas.DataUtil;
import Utilities.Browser.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.Browser.BrowserFactory.getDriver;

public class WaitsUtil {
    private static final LoggerUtil logger = LoggerUtil.getInstance();
    private static final DataUtil data = new DataUtil();


    public static boolean waitForElementPresence(By locator) {
//        BrowserUtil.scroll(getDriver().findElement(locator));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(data.readConfig().getTimeOfWait()));
        boolean isPresence = wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
        logger.logInfo("Result of element presence:" + isPresence);
        return isPresence;
    }

    public static void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(data.readConfig().getTimeOfWait()));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}