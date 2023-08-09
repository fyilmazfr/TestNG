package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentCarPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {
    @Test
    public void test01() {
        BlueRentCarPage blueRentCarPage = new BlueRentCarPage();
        //bir test method olustur PozitifLoginTest()
        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsUrl"));

        //login butonuna bas:: buraya basabilmek icin page sayfasinda objet olusturmamiz lazim, en yukariya yapabiliriz 11. satir yaptik
        blueRentCarPage.ilklogiButonu.click();


        //test data user email:customer@bluerentalcars.com
        blueRentCarPage.emailTextBox.sendKeys(ConfigReader.getProperty("bluerentalcarsEmail"));

        //test data password: 12345
        blueRentCarPage.passwordTextBox.sendKeys(ConfigReader.getProperty("bluerentalcarspassword"));

        //login butonuna tiklayin
        blueRentCarPage.ikinciLoginButonu.click();

        System.out.println(blueRentCarPage.kullaniciProfilIsmi.getText());

        //degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName = blueRentCarPage.kullaniciProfilIsmi.getText();
        String expectedUsername = ConfigReader.getProperty("bluerentalcarsUserName");
        Assert.assertEquals(actualUserName, expectedUsername);

        Driver.closeDriver();




    }
}
