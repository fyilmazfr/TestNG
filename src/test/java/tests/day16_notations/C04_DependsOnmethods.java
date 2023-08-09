package tests.day16_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C04_DependsOnmethods  {
    /*
    bu method testlerin calisma siralamasina karismaz, sadece bagli olan test beglandigi testin sonucuna bakar
    baglandigi test calismazsa kendini ignore eder.
     */
    WebDriver driver;

    @BeforeClass
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown(){
       driver.close();
    }

    @Test
    public void test01() {
        //amazon anasayfaya gidelim
        driver.get("https://www.Ramazon1.com");
    }

    @Test(dependsOnMethods ="test01")
    public void test02() {
        //nutella aratalim
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Nutella"+ Keys.ENTER);
    }
    @Test(dependsOnMethods = "test02")
    public void test03() {
        //sonuc yazisinin Nutella icerdigini test edelim
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));

    }
    @Test(groups = {"grup1","grup2"})
    public void test04(){
        System.out.println("Bak bu calisti");
    }
}
