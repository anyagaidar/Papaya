import base.BaseUtil;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HotLineMainPage;
import utils.RetryAnalyzer;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class HotLineMainPageTest extends BaseUtil {

    @BeforeMethod
    public void setUp() {
    webDriver.navigate().to("https://hotline.ua/");
        hotLinePageTest = new HotLineMainPage(webDriver);
    }
    private boolean result;
    HotLineMainPage hotLinePageTest;


    public void testMainPage() {
        result = hotLinePageTest.isWholePageOpened();
        Assert.assertTrue(result);
    }

    public void testBooksFoler() {
        result = hotLinePageTest.isBooksFolderPresents();
        Assert.assertTrue(result);
    }

    public void testSearchBox() {
        result = hotLinePageTest.isSearchBoxPresents();
        Assert.assertTrue(result);
    }

    public void testLoginBtn() {
        result = hotLinePageTest.isLoginFieldIsPresent();
        Assert.assertTrue(result);
    }

}
