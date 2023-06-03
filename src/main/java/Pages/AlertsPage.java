package Pages;

import BaseClasses.BaseForm;
import Elements.Button;
import Elements.Label;
import Utilities.AlertsUtil;
import org.openqa.selenium.By;

public class AlertsPage extends BaseForm {
    private final Button btnAlerts = new Button(By.id("alertButton"), "Alert Button");
    private final Button btnConfirm = new Button(By.id("confirmButton"), "Confirm Button");
    private final Button btnPrompt = new Button(By.id("promtButton"), "Prompt Button");
    private final Label labelConfirm = new Label(By.xpath("//span[@id='confirmResult'] [text()='You selected '] [text()='Ok']"), "Confirm Label");
    private final Label labelPrompt = new Label(By.xpath("//span[@id='promptResult'] [text()='You entered '] [text()='" + AlertsUtil.getRandomText() + "']"), "Prompt Label");

    public AlertsPage() {
        super(By.xpath("//div[@class='main-header'] [text()='Alerts']"), "Alerts Page");
    }

    public void clickAlertBtn() {
        btnAlerts.scrollToElement();
        btnAlerts.click();
    }

    public void clickConfirmBtn() {
        btnConfirm.scrollToElement();
        btnConfirm.click();
    }

    public void clickPromptBtn() {
        btnPrompt.scrollToElement();
        btnPrompt.click();
    }

    public boolean isLabelConfirmPresent() {
        return labelConfirm.isElementPresent();
    }

    public boolean isLabelPromptPresent() {
        return labelPrompt.isElementPresent();
    }
}