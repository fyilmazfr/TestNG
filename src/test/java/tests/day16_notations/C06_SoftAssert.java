package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {//C05'ten devam ediyoruz

    @Test(groups = "grup2")
    public void test01() {
        /*
        Softassertions baslangic ve bitis satirlari arasindaki tum assertions'lari yapip bitis satirina geldiginde
        bize buldugu tum hatalari rapor eder
        !!!  yani baslangici ve bitisi BELIRLEMEMIZ lazim
         */


        //Softassert baslangici obje olusturmaktir,  tum assert classlarini olusturdugumuz softAssert objesi ile degistirdik
        SoftAssert softAssert=new SoftAssert();




        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //title in amazon icerdigini test edin
        String expectedTitle="amazon";
        String actualTITLE=driver.getTitle();
        softAssert.assertTrue(actualTITLE.contains(expectedTitle),"title amazon icermiyor");

        // arama kutusunun erisilebilir oldugunu test edin
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramakutusu.isEnabled(),"arama kutusuna erisilemiyor");

        // arama kutusuna nutella yazip aratin
        aramakutusu.sendKeys("Nutella"+ Keys.ENTER);

        // arama yapildigini test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYaziElementi.isDisplayed(),"arama yapilamadi");

        // arama sonucunun nutella icerdigini test edin
        softAssert.assertTrue(sonucYaziElementi.getText().contains("Kutella"),"sonuc yazisi Kutella icermiyor");

                      //softAssert'e bitis satirini soylemek icin assertAll() KULLANILIR
                         //bu satir yazilmazsa assertion gorevi yapilmamis olur
        softAssert.assertAll();


    }

}
