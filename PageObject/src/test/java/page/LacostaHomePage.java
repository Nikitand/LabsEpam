package pageobject.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.Page;

public abstract class LacostaHomePage   extends Page {
    private static final String HOMEPAGE_URL = "https://lacoste.ru/";

    private WebDriver  driver;
    static int WAIT_TIMEOUT_SECONDS = 25;
    @FindBy(xpath = "//*[@id='search-render']/form/input[1]")
    private WebElement searchInput;

    public LacostaHomePage(WebDriver driver)
    {
        super(driver);


    }

    public  LacostaHomePage openPage()
    {
        driver.get(HOMEPAGE_URL);
                driver.manage().window().maximize();
        return this;
    }

     public SearchResultsWithParameter searchForTerms(String term)
     {
         searchInput.sendKeys(term);
         searchInput.sendKeys(Keys.ENTER);
         return new SearchResultsWithParameter(driver,term);
     }


}
