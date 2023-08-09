package tests.day21_reusableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentCarPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLoginTestiRaporlu extends TestBaseRapor {
    BlueRentCarPage blueRentCarPage = new BlueRentCarPage();
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve sifre ile giris yapabilmeli");

        //bir test method olustur PozitifLoginTest()
        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsUrl"));
        extentTest.info("Brc anasayfaya gidildi");

        //login butonuna bas:: buraya basabilmek icin page sayfasinda objet olusturmamiz lazim, en yukariya yapabiliriz 11. satir yaptik
        blueRentCarPage.ilklogiButonu.click();
        extentTest.info("login butonuna tiklandi");


        //test data user email:customer@bluerentalcars.com
        blueRentCarPage.emailTextBox.sendKeys(ConfigReader.getProperty("bluerentalcarsEmail"));
        extentTest.info("Gecerli email yazildi");

        //test data password: 12345
        blueRentCarPage.passwordTextBox.sendKeys(ConfigReader.getProperty("bluerentalcarspassword"));
        extentTest.info("Gecerli password yazildi");

        //login butonuna tiklayin
        blueRentCarPage.ikinciLoginButonu.click();
        extentTest.info("ikinci login butonuna tiklandi");

        System.out.println(blueRentCarPage.kullaniciProfilIsmi.getText());

        //degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName = blueRentCarPage.kullaniciProfilIsmi.getText();
        String expectedUsername = ConfigReader.getProperty("bluerentalcarsUserName");
        Assert.assertEquals(actualUserName, expectedUsername);
        extentTest.pass("kullanici basarili sekilde giris yapti");

        Driver.closeDriver();




    }

}
