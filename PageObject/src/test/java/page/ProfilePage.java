package page;

import AbstractPage.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends Page {


    private final String checkName="// div [@class='successCall']/div[1]";
    private final String checkEmail="// div [@class='successCall']/div[2]";
    private final String checkProduct="minicart-count";
   // private final By  productOnBasket = By.xpath("//span[@class = \"store-info-desc\" and contains(text(),\"МО\")]");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    public String getСheckName(){
        return waitForElementLocatedBy(driver, By.xpath(checkName), TIME_OUT_SECONDS).getText();
    }

    public String  getСheckEmail(){
        return waitForElementLocatedBy(driver, By.xpath(checkEmail), TIME_OUT_SECONDS).getText();
    }

    public String  getCheckProduct(){
        return waitForElementLocatedBy(driver, By.className(checkProduct), TIME_OUT_SECONDS).getText();
    }


   // public Boolean checkProductOnBasket(){
    //    WebElement productOn = new WebDriverWait(driver, TIME_OUT_SECONDS)
     //           .until(ExpectedConditions.presenceOfElementLocated(productOnBasket));
      //  return !(productOn.isDisplayed());
    //}
}
