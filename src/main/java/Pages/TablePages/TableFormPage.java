package Pages.TablePages;

import BaseClasses.BaseForm;
import Elements.Button;
import Datas.TestTableData;
import Utilities.Browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class TableFormPage extends BaseForm {
    private List<TestTableData> tableFilled;

    public TableFormPage() {
        super(By.xpath("//div[@class='web-tables-wrapper']"), "Table Form Page");
    }

    public List<TestTableData> pars() {
        tableFilled = new ArrayList<>();
        WebElement table = BrowserFactory.getDriver().findElement(By.xpath("//div[@class='rt-tbody']"));
        List<WebElement> rows = table.findElements(By.xpath("//div[@role='row']"));
        int i = 0;
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath("//div[@class='rt-td'][position() != 7]"));

            while (i < cells.size()) {
                TestTableData tableData = new TestTableData();
                tableData.setFirstName(cells.get(i).getText());
                tableData.setLastName(cells.get(++i).getText());
                tableData.setAge(cells.get(++i).getText());
                tableData.setEmail(cells.get(++i).getText());
                tableData.setSalary(cells.get(++i).getText());
                tableData.setDepartment(cells.get(++i).getText());
                tableFilled.add(tableData);
                ++i;
            }
        }
        return tableFilled;
    }

    public int lastIndexRow() {
        tableFilled = pars();
        int len = 0;
        int i = 0;
        while (len != 1) {
            len = tableFilled.get(i).getFirstName().length();
            i++;
        }
        return i - 1;
    }

    private Button deleteBtn() {
        return new Button(By.xpath("(//span[@title='Delete'])[" + lastIndexRow() + "]"), "Delete of Row Button");
    }

    public void clickDeleteBtn() {
        deleteBtn().scrollToElement();
        deleteBtn().click();
    }
}