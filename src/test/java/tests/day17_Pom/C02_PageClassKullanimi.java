package tests.day17_Pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {
    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();

        //amazona git
        Driver.getDriver().get("https://www.amazon.com");
        //nutella arat
        amazonPage.aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        //sonuc yazisinin nutella icerdigini test edelim
        String actualSonuc=amazonPage.aramaSonucElementi.getText();
        String arananKelime="nutella";

        Assert.assertTrue(actualSonuc.contains(arananKelime));
    }
}
