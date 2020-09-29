package base;

import manager.DriverManager;
import manager.DriverManagerFactory;
import manager.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseUtil {
    public WebDriver webDriver;
    DriverManager driverManager;

    @BeforeMethod
    @Parameters("browserName")
    public void setUp(@Optional String browserName) {
        getLocalDriver(browserName);
        webDriver.manage().window().maximize();
//        webDriver.navigate().to("https://www.google.com/");
    }
    public WebDriver getLocalDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
            webDriver = driverManager.getDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
            webDriver = driverManager.getDriver();
        } else {
            throw new RuntimeException("No such driver found!");
        }
        return webDriver;
    }
    @AfterMethod
    public void tearDown() {
        driverManager.quitDriver();
    }
}
