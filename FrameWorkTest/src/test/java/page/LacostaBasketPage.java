package page;

import model.Promo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LacostaBasketPage extends AbstractPage{

    @FindBy(className ="cart-sale-price")
    private WebElement coustBasketLocator;
    @FindBy(xpath ="//a[@class = \"cart-product-name\"]")
    private WebElement nameBasketLocator;
    @FindBy(xpath ="//div[@class = \"item-size\"]")
    private WebElement sizeInBasket;
    @FindBy(xpath ="//li[@class = \"cart-price-total\"]/span[2]")
    private WebElement allCoustInBasket;
    @FindBy(xpath = "//input[@class = \"checkout-input js-field\"]")
    private WebElement promoInput;
    @FindBy(xpath = "//span [@class = \"promocode-status\"]")
    private WebElement promoMessage;
    @FindBy(xpath = "//h3[@class=\"cart-empty-title\"]")
    private WebElement emptyBasket;
    @FindBy(className = "minicart-count")
    private WebElement countProductInBasket;

    private final By orderButtonLocator = By.xpath("//div[@class = \"cart-validation-wrapper\"]/a");
    private final By changeCountLocator = By.xpath("//div/select/option[@value = \"3\"]");
    private final By promoBoxLocator = By.xpath("//div[@class= \"cart-promo-code\"]/input");
    private final By deleteProductLocator = By.xpath("//li[@class=\"cart-product-action-remove\"]");

    private final String PAGE_URL = "https://lacoste.ru/cart/";

    public LacostaBasketPage (WebDriver driver){
        super(driver);
    }


    public LacostaBasketPage openPage() {
        driver.get(PAGE_URL);
        logger.info("open basket");
        return this;
    }

    public LacostaBasketPage closeWindow(){
        clickButtonByXpath(windowLocator);
        return this;
    }

    public  LacostaBasketPage changeCount(){
        clickButtonByXpath(changeCountLocator);
        return this;
    }

    public LacostaOrderingPage orderingProduct(){
        clickButtonByXpath(orderButtonLocator);
        return new LacostaOrderingPage(driver);
    }

    public  LacostaBasketPage enterUnRealPromo(Promo promo){
        clickButtonByXpath(promoBoxLocator);
        promoInput.sendKeys(promo.getPromo());
        promoInput.sendKeys(Keys.ENTER);
        return this;
    }

    public  LacostaBasketPage deleteProduct(){
        clickButtonByXpath(deleteProductLocator);
        return this;
    }

    public String getCoustInBasket() {
        return coustBasketLocator.getText();
    }
    public String getNameInBasket() {
        return nameBasketLocator.getText();
    }
    public String getSizeInBasket() {
        return sizeInBasket.getText();
    }
    public String getBeforeCoustInBasket() {
        return allCoustInBasket.getText();
    }
    public String getAllCoustInBasket() {
        return allCoustInBasket.getText();
    }
    public String getCheckEmptyBasket() {
        return emptyBasket.getText();
    }
    public String getCheckCount() {
        return countProductInBasket.getText();
    }

    public String getСheckCount(){
        return waitForElementLocatedBy(driver, changeCountLocator, TIME_OUT_SECONDS).getText();
    }

    public String getMessage() {
        return promoMessage.getText();
    }


}
