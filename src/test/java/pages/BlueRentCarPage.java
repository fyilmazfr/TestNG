package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentCarPage {//once bir constructor olusturmamiz lazim

    public BlueRentCarPage(){
        PageFactory.initElements(Driver.getDriver(),this); //this = constructor'a bu sayfada gecerli diyoruz
    }
    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement ilklogiButonu;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@id='formBasicPassword']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement ikinciLoginButonu;

    @FindBy(xpath = "//button[@id='dropdown-basic-button']")
    public WebElement kullaniciProfilIsmi;



}
