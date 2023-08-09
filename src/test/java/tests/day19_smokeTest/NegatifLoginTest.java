package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentCarPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegatifLoginTest {
    BlueRentCarPage blueRentCarPage=new BlueRentCarPage();

    @Test
    public void testyanlisSifre() {
        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsUrl"));

        //login butonuna bas
        blueRentCarPage.ilklogiButonu.click();


        //test data user email:SKSKS@GMAIL.COM
        blueRentCarPage.emailTextBox.sendKeys(ConfigReader.getProperty("bluerentalcarsEmail"));

        //test data yanlis password : 54321
        blueRentCarPage.passwordTextBox.sendKeys(ConfigReader.getProperty("bluerentalcarsWrongpassword"));

        //login butonuna tiklayin
        blueRentCarPage.ikinciLoginButonu.click();

        //degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(blueRentCarPage.ikinciLoginButonu.isDisplayed());


    }
}
