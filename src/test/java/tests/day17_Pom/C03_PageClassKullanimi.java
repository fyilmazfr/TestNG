package tests.day17_Pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {

    @Test
    public void test01() {
        FacebookPage facebookPage = new FacebookPage(); //18.satir icin bunu yaptik

        //facebook a git
        Driver.getDriver().get("https://facebook.com");
        //cikarsa cookies 'leri kabul edin
        facebookPage.cookiebutonu.click();

        //kullanici mail kutusuna rastgele bir isim yazdirin
        Faker faker = new Faker();
        facebookPage.mailkutusu.sendKeys(faker.internet().emailAddress());

        //kullanici sifre kutuusna rastgele bir pasword yazdirin
        facebookPage.sifrekutusu.sendKeys(faker.internet().password());

        //login butonuna basin
        facebookPage.loginkutusu.click();

        //giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
        Driver.closeDriver();

    }
}
