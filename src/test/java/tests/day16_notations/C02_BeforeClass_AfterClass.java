package tests.day16_notations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_BeforeClass_AfterClass extends TestBase {
    //JUnit'te @BeforeClass ve @AfterClass notasyonuna sahip method'lar static olmak zorundaydi
    //testNG bu zorunluluktan bizi kurtariyor

    /*
    tesNg bize daha fazla before ve after notasyonlari sunar diger
    before/after notasyonlari tanimlayacagimiz grup ,test veya suit'ten once veya sonra calisirlar ileride xml
    dosyalari ile birlikte bunu gorecegiz

     */

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("Before Class calisti");
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("After Class calisti");
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());

    }
    @Test
    public void test03() {
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getCurrentUrl());

    }

}
