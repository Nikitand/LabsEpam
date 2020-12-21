package test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.*;

public class LacostaTest {

    private WebDriver driver;
    private String size = "48";
    private String shirtName = "Рубашка Lacoste";
    private String email = "vitam7nd1@gmail.com";
    private String password = "3553356";
    private String name = "Осоприлко Никита";
    private String order  = "4";
    private String failTerms  = "Хот-дог";
    private String goodTerms  = "КУРТКА";
    private String failTermsResult  = "По запросу 'хот-дог' ничего не найдено";
    private String unRealPromo = "Example";
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
     //  Assert.assertTrue("missing name", checkBasket.checkNameShirt().contains(shirtName));
    }

    @Test
    public  void checkAvailabilityInStore()    {
        Boolean  checkAvailability = new TShirtPage(driver,"https://lacoste.ru/catalog/novye-postupleniya-muzhchiny/futbolka_lacoste_367_color_031/")
                .openPage()
                .addSize()
                .openPageCheckOnStoreFunction()
                .checkOnStore();
        //Assert.assertFalse("Not available in this store",checkAvailability);
    }

    @Test
    public  void loginAsLoggedInUser(){
        ProfilePage checkUser =  new LoginPage(driver, "https://lacoste.ru/account/auth/")
                .openPage()
                .inputEmail(email)
                .inputPassword(password)
                .openUserPage();
       // Assert.assertTrue("missing email", checkUser.getСheckEmail().contains(email));
       // Assert.assertTrue("missing name", checkUser.getСheckName().contains(name));
        //Assert.assertTrue("order", checkUser.getCheckProduct().contains(order));
    }

    @Test
    public void searchFailProduct(){
        SeacrhPage expectedSearchFailResult = new MainPage(driver, "https://lacoste.ru/")
                .openPage()
                .inputTerm(failTerms)
                .searchTerm();
       // Assert.assertTrue("failterms", expectedSearchFailResult.getСheckResult().contains(failTermsResult));
    }

    @Test
    public  void searchProductWithParametrs(){
        SeacrhPage expectedSearchResult =  new MainPage(driver, "https://lacoste.ru/")
                .openPage()
                .inputTerm(goodTerms)
                .searchTerm()
                .selectGenger()
                .selectSeason()
                .selectSize();

       // Assert.assertTrue("search result are empty!", searchResult.size()>0);
    }

    @Test
    public  void orderAnyProduct(){
        BasketPage checkBasket = new MenShirtPage(driver,"https://lacoste.ru/catalog/count_down_muzhchiny/rubashka_lacoste_regular_fit_303_color_800/")
                .openPage()
                .selectSize()
                .addToBasket()
                .openBasket()
                .changeCount();
        //3 assert
    }

    @Test
    public void orderingProduct(){
        OrderingPage checkOrder = new BasketPage(driver,"https://lacoste.ru/cart/" )
                .openPage()
                .orderingProduct();
                //Assert

    }

    @Test
    public  void enteringPromoCode(){
BasketPage checkPromoCode = new JacketPage(driver, "https://lacoste.ru/catalog/verkhnyaya-odezhda-muzhchiny/kurtka_lacoste_national_geographic_1_color_6T9/")
        .openPage()
        .addToBasket()
        .openBasket()
        .enterUnRealPromo(unRealPromo);
//assert
    }

    @AfterTest
    public void quiteBrowserAfterTest() {
        driver.quit();
    }
}