import base.BaseUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotLineLoginPage;
import utils.RetryAnalyzer;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class HotLineLoginPageTest extends BaseUtil {

//    public void incorrectLoginTest() {
//        webDriver.navigate().to("https://hotline.ua/");
//        HotLineLoginPage hotLinePageTest = new HotLineLoginPage(webDriver);
//        hotLinePageTest.pressLoginBtn();
//        hotLinePageTest.inputIncorrectLogin("anyagaidar12345@gmail.com");
//        hotLinePageTest.inputPassword("AnnaGd12345");
//        hotLinePageTest.pressSubmitBtn();
//        Assert.assertTrue(hotLinePageTest.isErrorMsgIsShown());
//    }

    public void correctLoginTest() {
        webDriver.navigate().to("https://hotline.ua/");
        HotLineLoginPage hotLinePageTest = new HotLineLoginPage(webDriver);
        hotLinePageTest.pressLoginBtn();
        hotLinePageTest.inputLogin("anyagaidar@gmail.com");
        hotLinePageTest.inputPassword("AnnaGd12345");
        hotLinePageTest.pressSubmitBtn();
        Assert.assertTrue(hotLinePageTest.isUserGetLogined());
    }

}
