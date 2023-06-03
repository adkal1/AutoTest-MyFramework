package Utilities.Browser;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserCapabilities {
    public static ChromeOptions getCapChrome() {
        return new ChromeOptions();
    }

    public static FirefoxOptions getCapFirefox() {
        return new FirefoxOptions();
    }
}