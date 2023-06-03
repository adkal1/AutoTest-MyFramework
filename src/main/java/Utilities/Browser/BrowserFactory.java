package Utilities.Browser;

import Datas.DataUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {
    private static final DataUtil data = new DataUtil();
    private static WebDriver driver;
    private static final String browserName = data.readConfig().getBrowser();

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (browserName) {
                case "Firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(BrowserCapabilities.getCapFirefox());
                    break;
                case "Chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(BrowserCapabilities.getCapChrome());
                    break;
                default:
                    throw new IllegalArgumentException("Browser " + browserName + " is invalid");
            }
        }
        return driver;
    }

    public static void setDriverNull() {
        driver = null;
    }
}