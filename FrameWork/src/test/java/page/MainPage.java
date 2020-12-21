package page;

import AbstractPage.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {

    private final By findBoxLocator = By.xpath("//input[@class = \"q\" ] ");
    @FindBy(className = "search-field")
    private WebElement searchInput;

    public MainPage(WebDriver driver, String MainPageUrl) {
        super(driver);
        this.url = MainPageUrl;
    }
    public MainPage openPage(){
        driver.get(url);
        return this;
    }

    public  MainPage inputTerm(String term) {
        clickButtonByXpath(findBoxLocator);
        searchInput.sendKeys(term);
        return this;
    }
    public SeacrhPage searchTerm(){
        searchInput.sendKeys(Keys.ENTER);
        return new SeacrhPage(driver);
    }
}
