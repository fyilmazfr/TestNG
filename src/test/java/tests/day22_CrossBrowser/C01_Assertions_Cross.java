package tests.day22_CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBaseCross;

public class C01_Assertions_Cross extends TestBaseCross {
    @Test
    public void test01() {

        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //title in amazon icerdigini test edin
        String expectedTitle="amazon";  // !!!
        String actualTITLE=driver.getTitle();
        Assert.assertFalse(actualTITLE.contains(expectedTitle));  //!!!

        // arama kutusunun erisilebilir oldugunu test edin
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramakutusu.isEnabled());

        // arama kutusuna nutella yazip aratin
        aramakutusu.sendKeys("Nutella"+ Keys.ENTER);

        // arama yapildigini test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());

        // arama sonucunun nutella icerdigini test edin
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));//buraya dikkat!!!


    }
}
