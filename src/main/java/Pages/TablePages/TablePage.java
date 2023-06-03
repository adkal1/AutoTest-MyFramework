package Pages.TablePages;

import BaseClasses.BaseForm;
import Elements.Button;
import org.openqa.selenium.By;

public class TablePage extends BaseForm {
    private final Button btnAdd = new Button(By.xpath("//button[@id='addNewRecordButton']"), "Add Registration data Button");

    public TablePage() {
        super(By.xpath("//div[@class='main-header'] [text()='Web Tables']"), "Table Page");
    }

    public void clickAddBtn() {
        btnAdd.scrollToElement();
        btnAdd.click();
    }
}