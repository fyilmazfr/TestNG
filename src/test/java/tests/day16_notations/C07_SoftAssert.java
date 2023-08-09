package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C07_SoftAssert extends TestBase {
    @Test
    public void test01() {
        driver.get("http://zero.webappsecurity.com/");
        //sign in butonunna basin
        driver.findElement(By.id("signin_button")).click();
        //login kutusuna username yazin
        WebElement logInKutusu= driver.findElement(By.xpath("//input[@name='user_login']"));
        logInKutusu.sendKeys("username");

        //pasword kutusuna password yazin
        WebElement paswordKutusu= driver.findElement(By.xpath("//input[@id='user_password']"));
        paswordKutusu.sendKeys("password");

        //signIn tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();

        //ONLINE BANKING menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //purchase foreign currency tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        //Currency drop down menusunden Eurozone'u secin
        WebElement dropdownobjesi=driver.findElement(By.xpath("//select[@name='currency']"));
        Select select=new Select(dropdownobjesi);
        select.selectByVisibleText("Eurozone (euro)");

        //softassert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String secilenOption=select.getFirstSelectedOption().getText();
        String expectedOption="Eurozone (Euro)";
        softAssert.assertEquals(secilenOption,expectedOption,"secilen option uygun degil");


























    }
}
