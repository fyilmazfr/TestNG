package tests.day17_Pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_YeniDriverIlkClass {
    @Test(groups = "grup1")
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com");

        /*
        bugune kadar Test base class'ina extend ederek kullandigimiz driver yerine bundan sonra Driver class'indan
        kullanacagimiz getDriver static method'unu kullanacagiz

         Driver.getDrive() bundan sonra  hep bunu kullanacagiz

         */
        //Driver.closeDriver(); ISTeRSEK DRIVER CLASSi buraya koy
        Driver.getDriver().get("https://www.bestbuy.com");
        Driver.getDriver().get("https://www.facebook.com");

        Driver.closeDriver();
    }
}
