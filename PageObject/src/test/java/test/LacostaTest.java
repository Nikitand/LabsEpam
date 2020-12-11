package test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.FutbolkaPage;
import page.BasketPage;
import page.MenShirtPage;

public class LacostaTest {

    WebDriver driver;
    private final  static  int size = 48;
    private  String shirtName = "\n" +
            "        Рубашка Lacoste\n" +
            "      ";

    @BeforeTest
    void browserStart() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void workWithBasket()    {
       BasketPage checkBasket = new MenShirtPage(driver,"https://lacoste.ru/catalog/count_down_muzhchiny/rubashka_lacoste_regular_fit_303_color_800/")
               .openPage()
               .selectSize()
               .addToBasket()
               .openBasket();
        Assert.assertTrue(checkBasket.checkSizeShirt().contains("size"));
        Assert.assertTrue(checkBasket.checkNameShirt().contains("shirtName"));
    }

    @Test
    public  void checkAvailabilityInStore()    {
        Boolean  checkAvailability = new FutbolkaPage(driver,"https://lacoste.ru/catalog/novye-postupleniya-muzhchiny/futbolka_lacoste_367_color_031/")
                .openPage()
                .addSize()
                .openPageCheckOnStoreFunction()
                .checkOnStore();
        Assert.assertFalse("Not available in this store",checkAvailability);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void quiteBrowserAfterTest() {
        driver.quit();
    }
}