package page;

import AbstractPage.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends Page {

    @FindBy(name = "USER_LOGIN")
    private WebElement inputEmailBox;
    @FindBy(name = "USER_PASSWORD")
    private WebElement inputPasswordBox;

    private final By enterLocator = By.xpath("//div [@class = \"column-half\" ] / button [@class = \"btn btn-secondary btn-full\"]");

    public LoginPage(WebDriver driver, String LoginPageUrl) {
        super(driver);
        this.url = LoginPageUrl;
    }

    public LoginPage openPage(){
        driver.get(url);
        return this;
    }

    public LoginPage inputEmail(String email){
        inputEmailBox.sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String password){
        inputPasswordBox.sendKeys(password);
        return this;
    }

    public ProfilePage openUserPage(){
        clickButtonByXpath(enterLocator);
        return new ProfilePage(driver);
    }

}
