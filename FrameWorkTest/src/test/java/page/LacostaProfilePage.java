package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public  class LacostaProfilePage  extends AbstractPage {


    private final String checkEmail="// div [@class='successCall']/div[2]";

    public LacostaProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getСheckEmail(){
        return waitForElementLocatedBy(driver, By.xpath(checkEmail), TIME_OUT_SECONDS).getText();
    }


}
