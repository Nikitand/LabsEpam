package page;

import AbstractPage.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends Page {

    private final String checkSize="item-size";
    private final String checkName="cart-product-name";

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String  checkSizeShirt(){
        return waitForElementLocatedBy(driver, By.className(checkSize), TIME_OUT_SECONDS).getText();
    }

    public String  checkNameShirt(){
        return waitForElementLocatedBy(driver, By.className(checkName), TIME_OUT_SECONDS).getText();
    }
}
