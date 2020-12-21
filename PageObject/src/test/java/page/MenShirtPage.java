package page;

import AbstractPage.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenShirtPage extends Page {



    public MenShirtPage(WebDriver driver, String menShirtUrl) {
        super(driver);
        this.url = menShirtUrl;
    }

    public  MenShirtPage openPage(){
        driver.get(url);
        return this;
    }

    public MenShirtPage selectSize(){
        clickButtonByXpath(selectSizeLocator);
        return this;
    }

    public MenShirtPage addToBasket(){
        clickButtonByXpath(addToBasketLocator);
        return this;
    }

    public  BasketPage openBasket(){
        clickButtonByXpath(openBasketLocator);
        return new BasketPage(driver);
    }
}
