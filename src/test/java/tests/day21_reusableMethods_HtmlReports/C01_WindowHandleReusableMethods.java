package tests.day21_reusableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_WindowHandleReusableMethods {
    @Test
    public void test01() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWH=Driver.getDriver().getWindowHandle();
        //click here butonuna basin
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> windowhandleSeti=Driver.getDriver().getWindowHandles();

        String ikinciSayfaWH="";
        for (String each:windowhandleSeti) {
            if (!each.equals(ilkSayfaWH)){
                ikinciSayfaWH=each;
            }

        }
        Driver.getDriver().switchTo().window(ikinciSayfaWH);
        System.out.println(Driver.getDriver().getTitle());

        //acilan yeni tab'in title'inin "New Window" oldugunu test edin
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.closeDriver();
    }

    @Test
    public void test02() {//!!! yukardaki test01 i reusable kullanarak cozuyoruz
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        //click here butonuna basin
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        //click here butonuna basin
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");// !!!!

        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.closeDriver();


    }
}
