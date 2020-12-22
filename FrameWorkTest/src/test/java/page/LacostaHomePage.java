package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LacostaHomePage extends  AbstractPage{

    private final By findBoxLocator = By.xpath("//input[@class = \"q\" ] ");

    @FindBy(className = "search-field")
    private WebElement searchInput;
   // WebElement searchInput =driver.findElement(By.className("search-field"));

    public LacostaHomePage(WebDriver driver, String HomePageUrl) {
        super(driver);
        this.url = HomePageUrl;
    }

    public LacostaHomePage openPage() {
        driver.get(url);
        return this;
    }

    public  LacostaHomePage inputTerm(String term) {
        clickButtonByXpath(findBoxLocator);
        searchInput.sendKeys(term);
        return this;
    }

    public LacostaSearchResultPage searchTerm(){
        searchInput.sendKeys(Keys.ENTER);
        return new LacostaSearchResultPage(driver);
    }


}
