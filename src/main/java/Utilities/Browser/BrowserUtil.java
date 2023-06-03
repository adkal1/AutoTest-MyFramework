package Utilities.Browser;

import Datas.DataUtil;
import Utilities.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {
    private static final LoggerUtil logger = LoggerUtil.getInstance();
    private static final DataUtil data = new DataUtil();

    public static void goToUrl() {
        String url = data.readConfig().getUrl();
        logger.logDebug("Navigating to URL:" + url);
        BrowserFactory.getDriver().get(url);
        logger.logInfo("Successfully navigated to URL:" + url);
    }

    public static void maximizeWindow() {
        BrowserFactory.getDriver().manage().window().maximize();
        logger.logInfo("Window is maximized");
    }

    public static void closeBrowser() {
        logger.logDebug("Browser is closed");
        BrowserFactory.getDriver().quit();
    }

    public static List<String> browserTabs() {
        return new ArrayList<>(BrowserFactory.getDriver().getWindowHandles());
    }

    public static void switchTab() {
        BrowserFactory.getDriver().switchTo().window(browserTabs().get(1));
        logger.logDebug("Tab is switched");
    }

    public static void returnTab() {
        BrowserFactory.getDriver().switchTo().window(browserTabs().get(0));
        logger.logWarning("Tab is returned");
    }

    public static void closeTab() {
        BrowserFactory.getDriver().close();
        logger.logWarning("Tab is closed");
    }

    public static boolean isOpenNewTab(int initialWindowCount) {
        int currentWindowCount = browserTabs().size();
        boolean resIsOpen = currentWindowCount == initialWindowCount + 1;
        logger.logInfo("Result of open new tab:" + resIsOpen);
        return resIsOpen;
    }

    public static void switchFrame(By locator) {
        BrowserFactory.getDriver().switchTo().frame(BrowserFactory.getDriver().findElement(locator));
        logger.logDebug("Frame is switched");
    }

    public static void exitFrame() {
        BrowserFactory.getDriver().switchTo().parentFrame();
        logger.logDebug("Frame is returned");
    }

    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}