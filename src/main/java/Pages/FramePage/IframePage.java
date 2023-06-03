package Pages.FramePage;

import BaseClasses.BaseForm;
import Elements.Label;
import org.openqa.selenium.By;


public class IframePage extends BaseForm {
    private final Label label = new Label(By.xpath("//h1[@id='sampleHeading']"), "Sample Heading IFrame");

    public IframePage() {
        super(By.xpath("//div[@id='framesWrapper']"), "IFrame Page");
    }

    public String getText() {
        return label.getText();
    }

}