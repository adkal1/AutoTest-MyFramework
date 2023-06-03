package Pages;

import BaseClasses.BaseForm;
import Elements.Button;
import org.openqa.selenium.By;

public class MenuWindows extends BaseForm {
    private final Button btnMenuAlert = new Button(By.xpath("//span[text()='Alerts']"), "Alerts Menu Button");
    private final Button btnMenuNestedFrames = new Button(By.xpath("//span[text()='Nested Frames']"), "Nested Frames Menu Button");
    private final Button btnMenuFrames = new Button(By.xpath("//span[text()='Frames']"), "Frames Menu Button");
    private final Button btnMenuTable = new Button(By.xpath("//span[text()='Web Tables']"), "Tables Menu Button");
    private final Button btnBrowserWin = new Button(By.xpath("//span[contains(text(), 'Browser')]"), "Browser Windows Menu Button");
    private final Button btnElement = new Button(By.xpath("//div[@class='element-group']"), "Element Menu Button");
    private final Button btnLinks = new Button(By.xpath("//span[text()='Links']/.."), "Links Menu Button");

    public MenuWindows() {
        super(By.xpath("//div[@class='main-header'] [text()='Alerts, Frame & Windows']"), "Accordion Menu Page");
    }

    public void clickBtnMenuAlert() {
        btnMenuAlert.scrollToElement();
        btnMenuAlert.click();
    }

    public void clickBtnMenuNestedFrames() {
        btnMenuNestedFrames.scrollToElement();
        btnMenuNestedFrames.click();
    }

    public void clickBtnMenuFrames() {
        btnMenuFrames.scrollToElement();
        btnMenuFrames.click();
    }

    public void clickBtnMenuTable() {
        btnMenuTable.scrollToElement();
        btnMenuTable.click();
    }

    public void clickBtnMenuBrowserWin() {
        btnBrowserWin.scrollToElement();
        btnBrowserWin.click();
    }

    public void clickBtnElement() {
        btnElement.scrollToElement();
        btnElement.click();
    }

    public void clickBtnLinks() {
        btnLinks.scrollToElement();
        btnLinks.click();
    }
}