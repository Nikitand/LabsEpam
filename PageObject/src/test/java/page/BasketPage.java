package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasketPage {

    private WebDriver driver;
    private final String checkSize="item-size";
    private final String checkName="cart-product-name";

    private final  static  int  TIME_OUT_SECONDS =  15  ;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String  checkSizeShirt(){
        return waitForElementLocatedBy(driver, By.className(checkSize), TIME_OUT_SECONDS).getText();
}

    public String  checkNameShirt(){
        return waitForElementLocatedBy(driver, By.className(checkName), TIME_OUT_SECONDS).getText();
}
    public static WebElement waitForElementLocatedBy(WebDriver driver, By by, long time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }


}
