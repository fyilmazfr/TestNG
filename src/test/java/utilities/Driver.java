package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    POM'da driver icin testBase class'ina extend etmek yerine driver class'indan static methodlar kullanarak
    driver olusturup ilgili ayarlarin
    yapilmasi ve en sonunda driver'in kapatilmasi tercih edilmistir
     */
    private Driver() {/* singleton Pattern: tekli kullanim bir class'in farkli claslardan obje olusturularak
        kullanimini ENGELLEMEK icin kullanilir
        Bunu saglamak icin yapmamiz gerekn sey oldukca basit obje olusturmak icin kullanilan constructor'i private
        yaptiginizda baska class'larda Driver class'indan obje olusturulmasi mumkun olamaz

        */


    }

    static WebDriver driver;

    public static WebDriver getDriver() {


        if (driver == null) {       //!!! tek bir driver sayfasin da calismak icin bunu yaptik
            switch (ConfigReader.getProperty("browser")) {
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

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
