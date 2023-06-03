package Pages.NestedFramesPage;

import BaseClasses.BaseForm;
import Elements.Label;
import org.openqa.selenium.By;

public class FrameNested extends BaseForm {

    private static final Label labelChild = new Label(By.xpath("//p[text()]"), "Child Iframe");
    private static final Label labelParent = new Label(By.xpath("//body[text()]"), "Parent Iframe");

    public FrameNested(By locator) {
        super(locator, "Frame Wrapper");
    }
    public String getTextChild() {
        return labelChild.getText();
    }
    public String getTextParent() {
        return labelParent.getText();
    }
}