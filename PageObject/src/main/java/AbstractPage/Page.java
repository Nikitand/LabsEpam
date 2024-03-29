package AbstractPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver driver;
    protected   String url;
    protected final  static  int  TIME_OUT_SECONDS =  25 ;
    protected final By cookiesLocator = By.xpath("//button[@class =\"close\"]");
    protected final By addToBasketLocator = By.xpath("//button[@class='btn btn-full btn-new l-cart-button']");
    protected final By selectSizeLocator = By.xpath("//a[@class = \"sizes-list__item\" and contains(text(), '48')]");
    protected final By openBasketLocator = By.id("top-minicart");
    protected Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickButtonByXpath(By by) {
        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .click();
    }
    protected static WebElement waitForElementLocatedBy(WebDriver driver, By by, long time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
