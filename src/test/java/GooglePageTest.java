//import org.junit.Test;

//import com.codeborne.selenide.webdriver.WebDriverFactory;

import base.BaseUtil;
import manager.DriverManager;
import manager.DriverManagerFactory;
import manager.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GooglePage;
import utils.RetryAnalyzer;

public class GooglePageTest extends BaseUtil {
//    DriverManager driverManager;
//    WebDriver webDriver;
//    BaseUtil baseUtil = new BaseUtil();
//    WebDriver webDriver = baseUtil.webDriver;

    //    @BeforeClass
//    public static void setUpClass() {
//        //executed only once, before the first test
//        System.setProperty("webdriver.chrome.driver", "src/browserDrivers/chromedriver.exe");
//    }
//    @BeforeTest
//    public void beforeTest() {
//    }
//
//    @BeforeMethod
//    public void beforeMethod() {
//        webDriver = driverManager.getDriver();
//    }
//    @AfterMethod
//    public void afterMethod() {
//        driverManager.quitDriver();
//    }
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void launchGoogleTest() {
////        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        webDriver.get("https://www.google.com/");
        webDriver.navigate().to("https://www.google.com/");

////        webDriver.findElement(By.name("q")).sendKeys("selenium", Keys.ENTER);
//////        Assert.assertTrue(webDriver.findElement(By.cssSelector(".srg .g:nth-child(1)")).getText().contains("Selenium"));
//        Assert.assertEquals("Google", webDriver.getTitle());
        GooglePage user = new GooglePage(webDriver);
        user.searchFor("Selenium");
        Assert.assertTrue(user.isOnResultPage());
    }

//    @After
//    public void tearDown() {
//        webDriver.quit();
//    }

}
