package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LacostaTShirtPage extends AbstractPage {

    private final By sizeProductLocator = By.xpath("//a[@class = \"sizes-list__item\" and  contains(text(),'46')]");
    private final By checkFunctionLocator = By.xpath("//a[@class = \"w2s-available no-variant-selected\"]");
    private final By cost = By.xpath("//a[@class = \"w2s-available no-variant-selected\"]");
    protected final By addToBasketLocator = By.xpath("//button[@class='btn btn-full btn-new l-cart-button']");
    protected final By openBasketLocator = By.id("top-minicart");

    private final String PAGE_URL = "https://lacoste.ru/catalog/novye-postupleniya-muzhchiny/futbolka_lacoste_367_color_031/";

    public LacostaTShirtPage(WebDriver driver) {
        super(driver);
    }

    public LacostaTShirtPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }
    public  LacostaTShirtPage closeCookies(){
        clickButtonByXpath(cookiesLocator);
        return this;
    }
    public LacostaTShirtPage addSize(){
        clickButtonByXpath(sizeProductLocator);
        return this;
    }
    public LacostaCheckInTheStorePage openPageCheckOnStoreFunction()    {
        clickButtonByXpath(checkFunctionLocator);
        return new LacostaCheckInTheStorePage(driver);
    }

    public LacostaTShirtPage addToBasket(){
        clickButtonByXpath(addToBasketLocator);
        return this;
    }


    public  LacostaBasketPage openBasket(){
        clickButtonByXpath(openBasketLocator);
        return new LacostaBasketPage(driver);
    }

}
