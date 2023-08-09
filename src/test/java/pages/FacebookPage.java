package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){//constructor yapmak zorundayiz
        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy(id="email")
    public WebElement mailkutusu;

    @FindBy(id="pass")
    public WebElement sifrekutusu;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginkutusu;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement girilemediYaziElementi;

    @FindBy(xpath = "//button[@class='_42ft _4jy0 _al65 _4jy3 _4jy1 selected _51sy']")
    public WebElement cookiebutonu;


}
