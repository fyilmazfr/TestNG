package NOTLAR;

public class Notlar {

}
    /*

                                       TestNG

*TestNg bize daha fazla notations sunar , before ve after notations lari sunar. bu notasyonlar kullanici da her method
 icin ayri ayri calismaz, soylendigi sekilde sadece bir kere calisir
*alfabetik siralama yada national order 'a gore calistirir

*
    JUnit'te @BeforeClass ve @AfterClass notasyonuna sahip method'lar static olmak zorundaydi
    testNG bu zorunluluktan bizi kurtariyor

*
tesNg bize daha fazla before ve after notasyonlari sunar
    diger before/after notasyonlari tanimlayacagimiz grup ,test veya suit'ten once veya sonra calisirlar ileride xml
    dosyalari ile birlikte bunu gorecegiz

*
TestNG isim methodlarini isim sirasina gore calistirir ,eger isim siralamasinin disinda bir siralama ile calismasini
    isterseniz o zaman test method'larina oncelik(priority) tanimlayabilirsiniz
    priority kucukten buyuge gore calisir . eger bir test methoduna priority degeri atanmamissa default olarak
    priority=0 kabul edilir.

    priorty ne kadar kucukse once o calisir
    eksi deger alabilir


*  dependsOnMethods  ==> bagimli
    @Test
    public void test01() {
        //amazon anasayfaya gidelim
        driver.get("https://www.Ramazon1.com");
    }

    @Test(dependsOnMethods ="test01")
    public void test02() {

  eger test 1i calistiramazsa (cunku yanlis sayfaya gitti ) test2 ye hic bakmaz biz oncesinde depends yaparak bagimli hale getiririz

*dependsOnmETHODS SIRALAMAYA HIC KARISMAZ, ZATEN BAGIMLIDIR

                              soft  ASSERTIONS
*TESTNG ile iki cesit asertions yapmak mumkundur
*her bir test case icin Assertions veya Verification kullanmaliyiz

*
 Softassertions baslangic ve bitis satirlari arasindaki tum assertions'lari yapip bitis satirina geldiginde
        bize buldugu tum hatalari rapor eder
        !!!  yani baslangici ve bitisi BELIRLEMEMIZ lazim

*
   Softassert baslangici obje olusturmaktir
        SoftAssert softAssert=new SoftAssert();
*
softAssert'e bitis satirini soylemek icin assertAll() KULLANILIR
        softAssert.assertAll();

*
softAssert satirlarina da string mesajlar birakabiliriz ,ornegin
softAssert.assertTrue(actualTITLE.contains(expectedTitle),"title amazon icermiyor");

                       POM, (PAGE OBJECT MODEL)
*  objeyi olustur her yerde kullan
*temel hedef test methodlarin'da elle girilen hicbir deger olmamalidir (url,locate,testdata
*
*   BAZEN NEGATIF TESTLER YAPILIR
* tekrar tekrar kullanacagimiz seyleri bir kere locate edip kullanmak amacli kullanilir
* daha iyi bir framework dizayni icin;
      maintenable
      reusable
      faster(daha hizli)
      understandable(anlasilabilir)
* Pom temelde 3 package icerir

    -Pages=web elementleri locate yapmak icin ve temel methodlar olusturmak icin kullanilir
    -Utilities= projemiz icin gerekli eksta kaynak; driver,TestBase ve ConfigurationReader class'larini icerir

    -Tests=sadece testleri execute etmek icin gerekli adimlari yazacagimiz class'lar icerir.hicbir data girisi
    yapmayacagiz


* STATIC METHODLARLA DRIVER'I KULLANACAGIZ
* page sayfasinda ilk yapmamiz gereken sey bir constructor olusturmak

* page paketinde kullandigimiz her bir page icin ayri bir pageClass olur orng; amazonpage, facebookPage gibi
 EGER test ettigimiz page'de cok fazla ozellik varsa her bir epik icin ayri page class'i olusturabiliriz

* herbir page sayfasi olusturdugumuzda ilk yapmamiz gereken parametresiz constructor olusturup ,
  constructor icinde pageFactory class'indan initElement() kullanip, Driver class'inda getDriver'in
  getirecegi driver'in bu class(this) gecerli olacagi tanimlamaktir

   public FacebookPage(){
        PageFactory.initElements(Driver.getDrive(),this);

   -pege sayfalarinda  bugune kadar locate icin kullandigimiz findElement veya findElements() yerine
    @FindBy notasyonu kullanilir.Degisen ikinci satir olur.

*Driver class'i olusturup bize driver dondurecek getDriver() ve driver'i kapatacak closeDriver() methodlarini
  olusturduk. bu iki methoda heryerden kolayca ulasabilmemiz icin methodlari static olarak tanimladik


                            POM 'da Properties File
*
public class ConfigReader {
  public static Properties properties;

    static {
        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            //fis dosyayolunu tanimladigimiz configuration.properties dosyasini okudu
            properties=new Properties();
            properties.load(fis);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getProperty(String key){
        test method'undan yolladigimiz String key degerini alip
        properties class'indan getProperty() methodunu kullanarak bu key'e ait value'u bize geirir

  return properties.getProperty(key);


*Configuration.properties
bu dosyayi testlerimizde kullanacagimiz url,test datalari gibi kullanicidan aldigimiz datalari dinamik yapmak icin
kullaniriz. tum testlerimizi bu sayfadan alacagimiz datalara gore dizayn ederiz boylece bu dosyada yapacagimiz
bir deger degisikli ile tum testCase'lerindeki test datalarini guncelleyebiliriz

*
singleton Pattern: tekli kullanim bir class'in farkli claslardan obje olusturularak
        kullanimini ENGELLEMEK icin kullanilir
        Bunu saglamak icin yapmamiz gerekn sey oldukca basit obje olusturmak icin kullanilan constructor'i private
        yaptiginizda baska class'larda Driver class'indan obje olusturulmasi mumkun olamaz

                              SMOKE TEST
* KUllandigimiz uygulamanin onemli temel fonksiyonlarini tets etmek icin yapilir.  genellikle sabah ilk ise baslama
gorevimizdir.Login,logout,sepete ekle,odeme yap... gibi temel islevleri test ederiz.Eger smoke test failed
olursa zaman gecirmeksizin tum ekibi haberdar ederiz.

*  pozitif login test
   negatif login test
   E2E testi(system testi),bastan sona test,uctan uca test.

*bir smoke testin bize adimlari verilmelidir,kafamiza gore test yapamayiz

                             XML File KULLANIMI
                             https://testng-docs.readthedocs.io/testngxml/
*src NEW FILE belirliClaslariClaistirma.xml // .xml yapmamiz lazim yoksa calismaz
     <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
     bunuda yapistirdik,olmazsa olmaz


*xml bizim projemize isteklerimizi imetmek icin hazirladigimiz bir emir verme haberlesme dosyasi.
*xml hem insanlarin hem makinalarin okuyabilacegi belgeleri kodlamak icin bir sozdilimi tanimlamak uzere
  World Wide Web Consortium(W3C) tarafindan olusturulan bir bicimlendirma dilidir

* biz de framework'umuzda belirli testleri veya tum testleri otomatik olarak calistirmak icin xml dosyalari kullaniriz

*birkez xml dosyai olusturup testlerimizi kolayca calistirabiliriz,herseferinde teste gidip tek tek onunla ugrasmaya
gerek yok

*  belirli clas calistirma
ilk satira <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >  yazilir
<suite name="istenen class'lari calistirma">
    <test name="classlar">
        <classes>
            <class name="tests.day16_notations.C03_Priority"></class>
            <class name="tests.day17_Pom.C01_YeniDriverIlkClass"></class>
        </classes>
    </test>


</suite>          //run yap ve calistir

* belirli package olusturma
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
*eger istedigimiz tum testlere ulasmak icin birden fazla hiyerarsi olusturmamiz gerekirse sonraki hiyerarsileri
uygun adimdan baslatmamiz gerekir
* Bir class'da tum test methodlari calisacaksa bunun icin direk class secmek yeterlidir.method secmemizin temel amaci
class icerisinde sadece belirlenen methodlarin calismasi veya belirlenen methodlar disinda ki tum methodlarin
calismasidir
*Eger calisacak spesifik methodlari belirtmek istersek inclusive
calismayacak spesifik methodlari belirtmek istersek exclusive keyword'leri kullanilir
*eger methodlar dependsOnMethods ile birbirine baglanmissa xml dosyasi calisirken celiski olusmamasi lazim celiski
durumunda selenium testleri calistirmaz

*suite tag'inin icine yazilacak verbose attribute konsolda cikan mesajlarin daha az veya daha cok olmasini belirler
1 en az
10 en cok
<suite name="istenen methodlar" verbose="3">

*    <suite name="belirli gruplar">
xml dosyalar calistiracagimiz suite ,test,veya diger secenekleri bir goreve gore gruplandirma icin de kullanilabilir
    bu durumda calisacak tum test methodlari veya class'lari tek tek xml dosyasina tanimlamak yerine
    framework'umuze istedigimiz test methodlarini istedigimiz gruplara dahil edebiliriz

    bunu yapabilmemiz icin o,nce test methodlarini istedigimiz gruplara dahil eder sonra xml dosyasinda
    1- hangi gruplar calisacak/calismayacak
    2- bu gruplar hangi package altinda aranacak

DIKKAT: eger exteds varsa ve grup olarak bir testi etiketlediysek o test calismaz

*groups ozelligi testin yanina yazilir

*      tum testleri calistirma
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="tum testleri calistirma">
    <test name="regression">
        <packages>
            <package name="tests.*"></package>
        </packages>
    </test>
</suite>

***
                 reusable methods class
*utilities de reusableMethods var bak!!!


                      HTML reports
                      ExtentReports mvn
*TESTNG rapor hazirlamaz eger testimiz ile ilgili rapor hazirlamak istersek farkli kutuphanelerden yardim almamiz
gerekir.
Pom.xml dosyamiza avenstack dependency'sini ekliyoruz.
* ornek olarak day 21 den positivelogintestRaporlu da html reports'u denedik ve calistirdik.oncesinde testBaseRapor'a
  extends yaptik

                       testNG Paralel Testing
*ayni anda birden fazla test calistirmak

                        Cross browser Testing

*cross browser testi bir uygulamayi farkli browserlar ile test etmek demektir
*Testleri sirali(sequential) veya paralel olarak yapabiliriz

*
1- yeni bir driver  class'i olusturulur : DriverCross
2-WebDriver getDriver(String browser)
3- browser=browser==null ? ConfigReader.getProperty("browser"): browser;

                                   DataProvider

*
@DataProvider
    public static Object[][] AranacakKelimeler() {


        Object[][] arananKelimeArrayi={{"Nutella"}, {"Java"},{"cigdem"}, {"Netherlands"}};
        return arananKelimeArrayi;
    }

     @Test(dataProvider = "AranacakKelimeler")// data saglayici
    public void dataProviderTesti(String arananKelime) {
        //arayacagimiz kelimeleri bir liste gibi tutup bana yollayacak bir veri saglayicisi olusturacagiz
        AmazonPage amazonPage=new AmazonPage();
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Nutella Java,cigdem ve Netherlands icin arama yapalim
        amazonPage.aramaKutusu.sendKeys("arananKelime"+ Keys.ENTER);


        //sonuclarin aradigimiz kelime icerdigini test edelim
        String expectedKelime="arananKelime";
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();

        //sayfayi kapatalim
        Driver.closeDriver();

    }*********************************

                                      CUCUMBER
*BDD (behaviour driven development) (davranis tabanli gelistirme)
* BDD icin Gherkin Language kullaniriz
*Proje de her bir davranis icin .feature uzantili bir Gherkin dosyasi olusturulur.
  given = verilen ,on sart
  When,and =anahtar kelimeleri ile Olayi
  Then =sonuc tanimlanir
















     */


















































































