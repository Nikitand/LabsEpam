package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LacostaOrderingPage  extends AbstractPage{

    public LacostaOrderingPage(WebDriver driver) {
        super(driver);
    }
    private final By orderButtonLocator = By.xpath("// div[@class=\"checkout-block checkout-block-full\"]//h3[contains(text(),\"нформ\")]");

        public Boolean checkInfoUser()    {
        WebElement userInfo = new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(orderButtonLocator));
        return !(userInfo.isDisplayed());
    }

}
