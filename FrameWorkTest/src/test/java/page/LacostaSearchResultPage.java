package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LacostaSearchResultPage extends AbstractPage {

    private final String checkResult="//div [@class= \"search-plug__inner\"]/ h2";

    public LacostaSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public  String  getCheckResultSeacrh(){
        return waitForElementLocatedBy(driver, By.xpath(checkResult), TIME_OUT_SECONDS).getText();
    }


}
