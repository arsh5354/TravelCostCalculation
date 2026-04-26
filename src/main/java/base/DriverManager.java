package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {        
        return driver;
    }

    public static WebDriver initializeDriver(String browser)  {

    	switch(browser) {
    	
    	case "chrome": driver = new ChromeDriver();break;
    	case "edge" : driver = new EdgeDriver();break;
    	case "firefox" : driver = new FirefoxDriver();break;
    	default : System.out.println("No matching browser");
    	return null;
    	}

        String url = ConfigReader.getProperty("app.url");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();

        return driver;
    }
//    
//    public static String getPath() {
//    	String fpath = System.getProperty("user.dir") +"/testdata/HotelDetails.xlsx";
//    	return fpath;
//    }

    public static void driverTearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
