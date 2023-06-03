package BaseTest;

import Utilities.Browser.BrowserFactory;
import Utilities.Browser.BrowserUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    @BeforeMethod
    public void setup() {
        BrowserFactory.getDriver();
        BrowserUtil.maximizeWindow();
        BrowserUtil.goToUrl();
    }

    @AfterMethod()
    public void close() {
        BrowserUtil.closeBrowser();
        BrowserFactory.setDriverNull();
    }
}