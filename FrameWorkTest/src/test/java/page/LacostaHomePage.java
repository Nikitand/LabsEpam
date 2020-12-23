package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LacostaHomePage extends  AbstractPage{


    private final By findBoxLocator = By.name("q");

    @FindBy(name = "q")
    private WebElement searchInput;

    public LacostaHomePage(WebDriver driver, String HomePageUrl) {
        super(driver);
        this.url = HomePageUrl;
    }

    public LacostaHomePage openPage() {
        driver.get(url);
        logger.info("Login page opened");
        return this;
    }

    public LacostaHomePage inputTerm(String term) {
        clickButtonByXpath(findBoxLocator);
        searchInput.sendKeys(term);
        logger.info("input term");
        return this;
    }

    public LacostaSearchResultPage searchTerm(){
        searchInput.sendKeys(Keys.ENTER);
        logger.info("search fail term");
        return new LacostaSearchResultPage(driver);
    }

    public LacostaSearchWithParameter searchGoodTerm(){
        searchInput.sendKeys(Keys.ENTER);
        logger.info("search good term");
        return new LacostaSearchWithParameter(driver);
    }
}
