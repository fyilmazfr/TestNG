package tests.day18_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {
    @Test
    public void test01() {
        FacebookPage facebookPage=new FacebookPage();

        //facebook a git
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        //cikarsa cookies 'leri kabul edin
        facebookPage.cookiebutonu.click();


        //kullanici mail kutusuna yanlis kullanici isim yazdirin
        facebookPage.mailkutusu.sendKeys(ConfigReader.getProperty("facebookWrongUserName"));

        //kullanici sifre kutusuna yanlis  pasword yazdirin
        facebookPage.sifrekutusu.sendKeys(ConfigReader.getProperty("facebookWrongPassword"));

        //login butonuna basin
        facebookPage.loginkutusu.click();


        //giris yapilamadigini test edin
       Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());


        //sayfayi kapatin
        Driver.closeDriver();

    }
}
