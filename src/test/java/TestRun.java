import BaseTest.BaseTest;
import Pages.*;
import Pages.FramePage.FramesPage;
import Pages.TablePages.RegistrationFormPage;
import Pages.NestedFramesPage.NestedFramesPage;
import Pages.TablePages.TableFormPage;
import Pages.TablePages.TablePage;
import Utilities.AlertsUtil;
import Utilities.Browser.BrowserUtil;
import Datas.DataUtil;
import Datas.TestTableData;
import Utilities.LoggerUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRun extends BaseTest {
    private static final MainPage mainPage = new MainPage();
    private static final AlertsPage alertsPage = new AlertsPage();
    private static final MenuWindows menuWindows = new MenuWindows();
    private static final NestedFramesPage nestedFramesPage = new NestedFramesPage();
    private static final FramesPage framesPage = new FramesPage();
    private static final TablePage tablePage = new TablePage();
    private static final TableFormPage tableFormPage = new TableFormPage();
    private static final RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    private static final BrowserMenuPage browserMenuPage = new BrowserMenuPage();
    private static final LinksPage linksPage = new LinksPage();
    private static final DataUtil data = new DataUtil();
    private static final LoggerUtil logger = LoggerUtil.getInstance();

    @Test
    public void testAlerts() {
        logger.logInfo("Test of Alerts is starting...");
        logger.logInfo("Test step 1");
        Assert.assertTrue(mainPage.isFormOpen(), "Main page is not open");
        mainPage.clickBtnStartAlerts();
        menuWindows.clickBtnMenuAlert();
        logger.logInfo("Step 2");
        Assert.assertTrue(alertsPage.isFormOpen(), "Alert form hasn't appeared on page");
        alertsPage.clickAlertBtn();
        logger.logInfo("Step 3");
        Assert.assertTrue(AlertsUtil.isAlertPresent(), "Alert is not open");
        Assert.assertTrue(AlertsUtil.isTrueAssertText(data.readTestData().getAlertText()), "Alert with text 'You clicked a button' is not open");
        AlertsUtil.clickOkAlertPresent();
        logger.logInfo("Step 4");
        Assert.assertFalse(AlertsUtil.isAlertPresent(), "Alert is open");
        alertsPage.clickConfirmBtn();
        logger.logInfo("Step 5");
        Assert.assertTrue(AlertsUtil.isAlertPresent(), "Alert is not open");
        Assert.assertTrue(AlertsUtil.isTrueAssertText(data.readTestData().getAlertConfirmText()), "Alert with text 'Do you confirm action?' is not open");
        AlertsUtil.clickOkAlertPresent();
        logger.logInfo("Step 6");
        Assert.assertFalse(AlertsUtil.isAlertPresent(), "Alert is open");
        Assert.assertTrue(alertsPage.isLabelConfirmPresent(), "Text 'You selected Ok' hasn't appeared on page");
        alertsPage.clickPromptBtn();
        logger.logInfo("Step 7");
        Assert.assertTrue(AlertsUtil.isAlertPresent(), "Alert is not open");
        Assert.assertTrue(AlertsUtil.isTrueAssertText(data.readTestData().getAlertPromptText()), "Alert with text 'Please enter your name' isn't open");
        AlertsUtil.setAlertText();
        AlertsUtil.clickOkAlertPresent();
        logger.logInfo("Step 8");
        Assert.assertFalse(AlertsUtil.isAlertPresent(), "Alert is open");
        Assert.assertTrue(alertsPage.isLabelPromptPresent(), "Appeared text doesn't equal to the one you've entered before");
    }

    @Test
    public void testIframe() {
        logger.logInfo("Test of IFrame is starting ...");
        logger.logInfo("Step 1");
        Assert.assertTrue(mainPage.isFormOpen(), "Main page is not open");
        mainPage.clickBtnStartAlerts();
        menuWindows.clickBtnMenuNestedFrames();
        logger.logInfo("Step 2");
        Assert.assertTrue(nestedFramesPage.isFormOpen(), "Page with Nested Frames form isn't open");
        Assert.assertEquals(nestedFramesPage.parentFrameText(), data.readTestData().getParentFrameText(), "There are not message 'Parent frame'");
        Assert.assertEquals(nestedFramesPage.childFrameText(), data.readTestData().getChildFrameText(), "There are not message 'Parent frame'");
        BrowserUtil.exitFrame();
        BrowserUtil.exitFrame();
        menuWindows.clickBtnMenuFrames();
        logger.logInfo("Step 3");
        Assert.assertTrue(framesPage.isFormOpen(), "Page with Frames form isn't open");
        Assert.assertEquals(framesPage.getFrameUpText(), framesPage.getFrameDownText(), "Message from upper frame is not equal to the message from lower frame");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{data.readTestTableData().get(0)}, {data.readTestTableData().get(1)}};
    }

    @Test(dataProvider = "data-provider")
    public void testTables(TestTableData datas) {
        logger.logInfo("Test of Tables is starting ...");
        logger.logInfo("Step 1");
        Assert.assertTrue(mainPage.isFormOpen(), "Main page is not open");
        mainPage.clickBtnElements();
        menuWindows.clickBtnMenuTable();
        logger.logInfo("Step 2");
        Assert.assertTrue(tablePage.isFormOpen(), "Page with Web Tables form isn't open");
        tablePage.clickAddBtn();
        logger.logInfo("Step 3");
        registrationFormPage.scrollToUniqueLocator();
        Assert.assertTrue(registrationFormPage.isFormOpen(), "Registration Form hasn't appeared on page");
        registrationFormPage.addUsers(datas);
        registrationFormPage.clickCloseBtn();
        logger.logInfo("Step 4");
        Assert.assertTrue(tableFormPage.pars().contains(datas), "Registration form is open. Data of User# hasn't appeared in a table");
        tableFormPage.clickDeleteBtn();
        logger.logInfo("Step 5");
        Assert.assertFalse(tableFormPage.pars().contains(datas), "Number of records in table hasn't changed. Data of User# hasn't been deleted from table");
    }

    @Test
    public void testHandles() {
        logger.logInfo("Test of Handles is starting");
        logger.logInfo("Step 1");
        Assert.assertTrue(mainPage.isFormOpen(), "Main page isn't open");
        mainPage.clickBtnStartAlerts();
        menuWindows.clickBtnMenuBrowserWin();
        logger.logInfo("Step 2");
        Assert.assertTrue(browserMenuPage.isFormOpen(), "Page with Browser Windows form isn't open");
        browserMenuPage.clickBtnTab();
        BrowserUtil.switchTab();
        logger.logInfo("Step 3");
        Assert.assertTrue(BrowserUtil.isOpenNewTab(browserMenuPage.getInitialWindowsCount()), "New tab with sample page isn't open");
        BrowserUtil.closeTab();
        BrowserUtil.returnTab();
        logger.logInfo("Step 4");
        Assert.assertTrue(browserMenuPage.isFormOpen(), "Page with browser Windows form isn't open");
        menuWindows.clickBtnElement();
        menuWindows.clickBtnLinks();
        logger.logInfo("Step 5");
        Assert.assertTrue(linksPage.isFormOpen(), "Page with Links form isn't open");
        linksPage.clickHomeLink();
        BrowserUtil.switchTab();
        logger.logInfo("Step 6");
        Assert.assertTrue(mainPage.isFormOpen(), "New tab with main page isn't open");
        BrowserUtil.returnTab();
        logger.logInfo("Step 7");
        Assert.assertTrue(linksPage.isFormOpen(), "Page with Links form isn't open");
    }
}