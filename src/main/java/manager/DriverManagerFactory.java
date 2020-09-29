package manager;

public class DriverManagerFactory {
    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager = null;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                  driverManager = new FirefoxDriverManager();
                break;
            case IE:
//                driverManager = new InternetExplorerDriverManager();
                break;
            default:
                //   driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
