package Pages.NestedFramesPage;

import BaseClasses.BaseForm;
import Utilities.Browser.BrowserUtil;
import org.openqa.selenium.By;

public class NestedFramesPage extends BaseForm {
    private final FrameNested frameParent = new FrameNested(By.xpath("//body[text()='Parent frame']"));
    private final FrameNested frameChild = new FrameNested(By.xpath("//p[text()='Child Iframe']"));

    public NestedFramesPage() {
        super(By.xpath("//div[@class='main-header'] [text()='Nested Frames']"), "Nested Frames Page");
    }

    public String parentFrameText() {
        BrowserUtil.switchFrame(By.xpath("//iframe[@id='frame1']"));
        return frameParent.getTextParent();
    }

    public String childFrameText() {
        BrowserUtil.switchFrame(By.xpath("//iframe"));
        return frameChild.getTextChild();
    }
}