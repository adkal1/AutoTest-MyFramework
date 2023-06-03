package Pages;

import BaseClasses.BaseForm;
import Elements.Link;
import org.openqa.selenium.By;

public class LinksPage extends BaseForm {
    private final Link linkHome = new Link(By.xpath("//a[@id='simpleLink']"), "Home Link");

    public LinksPage() {
        super(By.xpath("//div[@class='main-header'] [text()='Links']"), "Links Page");
    }

    public void clickHomeLink() {
        linkHome.scrollToElement();
        linkHome.click();
    }
}
