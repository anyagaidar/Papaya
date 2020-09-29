package manager;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

public class FirefoxDriverManager extends DriverManager {
    private GeckoDriverService geckoService;
    @Override
    protected void startService() {
        if (null == geckoService) {
            try {
                geckoService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File("src/browserDrivers/geckodriver.exe"))
                        .usingAnyFreePort()
                        .build();
                geckoService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void stopService() {
        if (null != geckoService && geckoService.isRunning())
            geckoService.stop();
    }
    @Override
    protected void createDriver() {
        driver = new FirefoxDriver(geckoService);
    }
}
