package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import model.*;

public class LacostaLoginPage extends  AbstractPage {

    protected final String url;
    @FindBy(name = "USER_LOGIN")
    private WebElement inputEmailBox;
    @FindBy(name = "USER_PASSWORD")
    private WebElement inputPasswordBox;

    private final By enterButtonLocator = By.xpath("//div [@class = \"column-half\" ] / button [@class = \"btn btn-secondary btn-full\"]");

    public LacostaLoginPage(WebDriver driver, String LoginPageUrl) {
        super(driver);
        this.url = LoginPageUrl;
    }

    public LacostaLoginPage openPage() {
        driver.get(url);
        return this;
    }

    public  LacostaLoginPage login(User user){
            inputEmailBox.sendKeys(user.getUsername());
            inputPasswordBox.sendKeys(user.getPassword());
            return  this;
    }

    public  LacostaProfilePage openProfilePage(){
        clickButtonByXpath(enterButtonLocator);
        return new LacostaProfilePage(driver);
    }


}
