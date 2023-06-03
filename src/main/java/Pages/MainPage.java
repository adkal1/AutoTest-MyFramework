package Pages;

import BaseClasses.BaseForm;
import Elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
    private final Button btnAlertsWin = new Button(By.xpath("//h5[contains(text(), 'Alerts')]"), "Alerts, Frame & Windows Button");
    private final Button btnElementsWin = new Button(By.xpath("//h5[contains(text(), 'Elements')]"), "Elements Button");

    public MainPage() {
        super(By.xpath("//div[@class='home-banner']"), "Main Page");
    }

    public void clickBtnStartAlerts() {
        btnAlertsWin.scrollToElement();
        btnAlertsWin.click();
    }

    public void clickBtnElements() {
        btnElementsWin.scrollToElement();
        btnElementsWin.click();
    }

}