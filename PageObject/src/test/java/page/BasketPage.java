package page;

import AbstractPage.Page;
import org.apache.tools.ant.taskdefs.condition.Or;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends Page {

    private final String checkSize="item-size";
    private final String checkName="cart-product-name";
    private final By changeCountLocator = By.xpath("//div/select/option[@value = \"1\"]");
    private final By orderButtonLocator = By.xpath("//div[@class = \"cart-validation-wrapper\"]/a");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public  BasketPage(WebDriver driver, String orderingPageUrl){
        super(driver);
        this.url = orderingPageUrl;
    }

    public BasketPage openPage(){
        driver.get(url);
        return this;
    }

    public OrderingPage orderingProduct(){
        clickButtonByXpath(orderButtonLocator);
        return new OrderingPage(driver);
    }

    public  BasketPage changeCount(){
        clickButtonByXpath(changeCountLocator);
        return this;
    }

    public String  checkSizeShirt(){
        return waitForElementLocatedBy(driver, By.className(checkSize), TIME_OUT_SECONDS).getText();
    }

    public String  checkNameShirt(){
        return waitForElementLocatedBy(driver, By.className(checkName), TIME_OUT_SECONDS).getText();
    }
}
