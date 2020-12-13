package test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.TShirtPage;
import page.BasketPage;
import page.MenShirtPage;

public class LacostaTest {

    private WebDriver driver;
    private String size = "48";
    private  String shirtName = "Рубашка Lacoste";

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
        Assert.assertTrue("missing size", checkBasket.checkSizeShirt().contains(size));
       Assert.assertTrue("missing name", checkBasket.checkNameShirt().contains(shirtName));
    }

    @Test
    public  void checkAvailabilityInStore()    {
        Boolean  checkAvailability = new TShirtPage(driver,"https://lacoste.ru/catalog/novye-postupleniya-muzhchiny/futbolka_lacoste_367_color_031/")
                .openPage()
                .addSize()
                .openPageCheckOnStoreFunction()
                .checkOnStore();
        Assert.assertFalse("Not available in this store",checkAvailability);
    }

    @AfterTest
    public void quiteBrowserAfterTest() {
        driver.quit();
    }
}