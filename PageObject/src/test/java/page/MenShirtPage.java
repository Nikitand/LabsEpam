package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MenShirtPage {

    private WebDriver driver;
    private  String url;

    private final By selectSizeLocator = By.xpath("//a[@class = \"sizes-list__item\" and contains(text(), '48')]");
    private final By addToBasketLocator = By.className("btn-new l-cart-button");
    private final By openBasketLocator = By.id("top-minicart");
    private final By cookiesLocator = By.id("cookie-policy");

    private final  static  int  TIME_OUT_SECONDS =  15  ;

    public MenShirtPage(WebDriver driver, String menShirtUrl) {
        this.url = menShirtUrl;
        this.driver = driver;
    }

    public  MenShirtPage openPage(){
        driver.get(url);
        return this;
    }

    public MenShirtPage selectSize(){
        clickButtonByXpath(cookiesLocator);
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

    private void clickButtonByXpath(By by) {
        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .click();
    }
}
