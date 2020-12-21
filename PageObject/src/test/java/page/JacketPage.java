package page;

import AbstractPage.Page;
import org.openqa.selenium.WebDriver;

public class JacketPage extends Page {


    public JacketPage(WebDriver driver, String jacketPageUrl) {
        super(driver);
        this.url = jacketPageUrl;
    }

    public   JacketPage openPage(){
        driver.get(url);
        return this;
    }

    public JacketPage addToBasket(){
        clickButtonByXpath(selectSizeLocator);
        clickButtonByXpath(addToBasketLocator);
        return this;
    }

    public BasketPage openBasket(){
        clickButtonByXpath(openBasketLocator);
        return  new BasketPage(driver);
    }

}
