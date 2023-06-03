package Pages.FramePage;

import BaseClasses.BaseForm;
import Utilities.Browser.BrowserUtil;
import org.openqa.selenium.By;

public class FramesPage extends BaseForm {
    private final IframePage frameUp = new IframePage();
    private final IframePage frameDown = new IframePage();

    public FramesPage() {
        super(By.xpath("//div[@class='main-header'] [text()='Frames']"), "Frames Page");
    }

    public String getFrameUpText() {
        BrowserUtil.switchFrame(By.xpath("//iframe[@id='frame1']"));
        String text = frameUp.getText();
        BrowserUtil.exitFrame();
        return text;
    }

    public String getFrameDownText() {
        BrowserUtil.switchFrame(By.xpath("//iframe[@id='frame2']"));
        String text = frameDown.getText();
        BrowserUtil.exitFrame();
        return text;
    }
}