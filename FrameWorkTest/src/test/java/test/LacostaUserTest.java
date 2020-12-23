package test;

import model.Promo;
import model.TShirt;
import model.User;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;
import page.*;
import service.PromoCreator;
import service.UserCreator;
import service.TShirtCreator;

public class LacostaUserTest extends CommonConditions {

   @Test(priority = 1)
    public  void loginAsLoggedInUser(){
        User testUser = UserCreator.withCredentialsFromProperty();
        LacostaProfilePage checkUser =  new LacostaLoginPage(driver,"https://lacoste.ru/account/auth/")
                .openPage()
                .login(testUser)
                .openProfilePage();

        assertThat(checkUser.getСheckEmail().contains(testUser.getUsername())).isTrue();
    }

    @Test(priority = 2)
    public void searchWithFailedTerms(){
        LacostaSearchResultPage checkResult  = new LacostaHomePage(driver, "https://lacoste.ru/")
                .openPage()
                .inputTerm(failTerms)
                .searchTerm();

        assertThat(checkResult.getCheckResultSeacrh().contains(failResult)).isFalse();
    }

    @Test(priority = 3)
    public void checkAvailabilityInStore(){
        TShirt tShirt = TShirtCreator.withCredentialsFromProperty();
        Boolean checkAvailability = new LacostaTShirtPage(driver,"https://lacoste.ru/catalog/novye-postupleniya-muzhchiny/futbolka_lacoste_367_color_031/")
                .openPage()
                .closeCookies()
                .addSize()
                .openPageCheckOnStoreFunction()
                .checkOnStore();

        assertThat(checkAvailability).isFalse();
    }

    @Test(priority = 4)
    public void workWithBasket()    {
        LacostaBasketPage checkBasket = new LacostaTShirtPage(driver,"https://lacoste.ru/catalog/novye-postupleniya-muzhchiny/futbolka_lacoste_367_color_031/")
                .openPage()
                .addSize()
                .addToBasket()
                .openBasket()
                .closeWindow();

        assertThat(checkBasket.getNameInBasket()).isEqualTo("ФУТБОЛКА LACOSTE");
        assertThat(checkBasket.getSizeInBasket()).isEqualTo("Размер: 46");
    }

    @Test(priority = 5)
    public  void orderAnyProduct(){
        LacostaBasketPage checkBasket = new LacostaTShirtPage(driver,"https://lacoste.ru/catalog/novye-postupleniya-muzhchiny/futbolka_lacoste_367_color_031/")
                .openPage()
                .addSize()
                .addToBasket()
                .openBasket()
                .changeCount();

        assertThat(checkBasket.getNameInBasket()).isEqualTo("ФУТБОЛКА LACOSTE");
        assertThat(checkBasket.getСheckCount().contains(countProduct)).isTrue();
        assertThat(checkBasket.getAllCoustInBasket()).isEqualTo("5 572 РУБ.");
    }

    @Test(priority = 6)
    public void orderingProduct(){
        Boolean checkOrder = new LacostaBasketPage(driver,"https://lacoste.ru/cart/")
                .openPage()
                .orderingProduct()
                .checkInfoUser();

        assertThat(checkOrder).isFalse();
    }

    @Test(priority = 7)
    public  void enteringPromoCode(){
        Promo failpromo = PromoCreator.withCredentialsFromProperty();
        LacostaBasketPage checkPromoCode = new LacostaBasketPage(driver, "https://lacoste.ru/cart/")
                .openPage()
                .enterUnRealPromo(failpromo)
                .openPage();

        assertThat(checkPromoCode.getMessage()).isEqualTo("не найден");
        assertThat(checkPromoCode.getBeforeCoustInBasket()).isEqualTo("8 358 РУБ.");
        assertThat(checkPromoCode.getAllCoustInBasket()).isEqualTo("8 358 РУБ.");
    }

    @Test(priority = 8)
    public  void deleteWithBasket(){
        LacostaBasketPage resultBasket =  new LacostaBasketPage(driver, "https://lacoste.ru/cart/")
                .openPage()
                .deleteProduct()
                .openPage();

       assertThat(resultBasket.getCheckEmptyBasket()).isEqualTo("ВАША КОРЗИНА ПУСТА");
        assertThat(resultBasket.getCheckCount()).isEqualTo(0);
    }
}
