package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import model.*;

public class LacostaLoginPage extends  AbstractPage {


    @FindBy(name = "USER_LOGIN")
    private WebElement inputEmailBox;
    @FindBy(name = "USER_PASSWORD")
    private WebElement inputPasswordBox;

    private final By enterButtonLocator = By.xpath("//div [@class = \"column-half\" ] / button [@class = \"btn btn-secondary btn-full\"]");

    private  final String  PAGE_URL="https://lacoste.ru/catalog/novye-postupleniya-muzhchiny/futbolka_lacoste_367_color_031/";

    public LacostaLoginPage(WebDriver driver) {
        super(driver);
    }

    public LacostaLoginPage openPage() {
        driver.get(PAGE_URL);
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
