package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {
    private  CrossDriver() {

    }

    static WebDriver driver;

    public static WebDriver getDriver(String browser) {//String browser ekledik
        browser=browser==null ? ConfigReader.getProperty("browser"): browser;// TERNARY yaptik burda


        if (driver == null) {       //!!! tek bir driver sayfasin da calismak icin bunu yaptik
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));//bunu selenium artik desteklemiyor
                default:
                    WebDriverManager.chromedriver().setup();//aksilik durumunda yine chrome calissin dedik.
                    driver = new ChromeDriver();

            }


        }

        return driver;

    }

    public static void closeDriver() {
        if (driver != null) { //! bu defa tersten yaptik
            driver.close();
            driver = null; // yukariya gittiginde 20. satir icin


        }

    }
}


