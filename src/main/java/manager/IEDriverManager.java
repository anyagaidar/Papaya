package manager;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class IEDriverManager extends DriverManager {
    private InternetExplorerDriverService ieService;

    @Override
    protected void startService() {
        if (null == ieService) {
            try {
                ieService = new InternetExplorerDriverService.Builder()
                        .usingAnyFreePort()
                        .build();
                ieService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void stopService() {
        if (null != ieService && ieService.isRunning())
            ieService.stop();
    }
    @Override
    protected void createDriver() {
        driver = new InternetExplorerDriver(ieService);
    }
}
