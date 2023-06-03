package Pages.TablePages;

import BaseClasses.BaseForm;
import Elements.Button;
import Elements.TextBox;
import Datas.TestTableData;
import org.openqa.selenium.By;

import static Utilities.Browser.BrowserFactory.getDriver;
import static Utilities.Browser.BrowserUtil.scroll;
import static Utilities.WaitsUtil.waitForElementToBeClickable;


public class RegistrationFormPage extends BaseForm {
    private final TextBox boxFirstName = new TextBox(By.xpath("//div[@id='firstName-wrapper']//input"), "First Name Textbox");
    private final TextBox boxLastName = new TextBox(By.xpath("//div[@id='lastName-wrapper']//input"), "Last Name Textbox");
    private final TextBox boxEmail = new TextBox(By.xpath("//div[@id='userEmail-wrapper']//input"), "Email Textbox");
    private final TextBox boxAge = new TextBox(By.xpath("//div[@id='age-wrapper']//input"), "Age Textbox");
    private final TextBox boxSalary = new TextBox(By.xpath("//div[@id='salary-wrapper']//input"), "Salary Textbox");
    private final TextBox boxDepartment = new TextBox(By.xpath("//div[@id='department-wrapper']//input"), "Department Textbox");
    private final Button btnSubmit = new Button(By.xpath("//button[@id='submit']"), "Submit Button");
    private final Button btnClose = new Button(By.xpath("//button[@class='close']"), "Close Button");
    private final TablePage tablePage = new TablePage();

    public RegistrationFormPage() {
        super(By.xpath("//div[@id='registration-form-modal']"), "Registration Form Page");
    }

    public void addFirstName(String firstName) {
        boxFirstName.setText(firstName);
    }

    public void addLastName(String lastName) {
        boxLastName.setText(lastName);
    }

    public void addEmail(String email) {
        boxEmail.setText(email);
    }

    public void addAge(String age) {
        boxAge.setText(age);
    }

    public void addSalary(String salary) {
        boxSalary.setText(salary);
    }

    public void addDepartment(String department) {
        boxDepartment.setText(department);
    }

    public void addUsers(TestTableData data) {
        addFirstName(data.getFirstName());
        addLastName(data.getLastName());
        addEmail(data.getEmail());
        addAge(data.getAge());
        addSalary(data.getSalary());
        addDepartment(data.getDepartment());
        btnSubmit.scrollToElement();
        btnSubmit.click();
        tablePage.clickAddBtn();
    }

    public void clickCloseBtn() {
        btnClose.scrollToElement();
        btnClose.click();
    }
    public void scrollToUniqueLocator() {
        waitForElementToBeClickable(By.xpath("//div[@id='registration-form-modal']"));
        scroll(getDriver().findElement(By.xpath("//div[@id='registration-form-modal']")));
    }

}