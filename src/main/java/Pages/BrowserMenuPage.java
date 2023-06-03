package Pages;

import BaseClasses.BaseForm;
import Elements.Button;
import Utilities.Browser.BrowserUtil;
import org.openqa.selenium.By;

public class BrowserMenuPage extends BaseForm {
    private final Button btnTab = new Button(By.xpath("//button[@id='tabButton']"), "Tab Button");
    private static int initialWindowsCount;

    public BrowserMenuPage() {
        super(By.xpath("//div[@class='main-header'] [text()='Browser Windows']"), "Browser Menu Page");
    }

    public void clickBtnTab() {
        setInitialWindowsCount();
        btnTab.scrollToElement();
        btnTab.click();
    }

    public void setInitialWindowsCount() {
        BrowserMenuPage.initialWindowsCount = BrowserUtil.browserTabs().size();
    }

    public int getInitialWindowsCount() {
        return initialWindowsCount;
    }
}