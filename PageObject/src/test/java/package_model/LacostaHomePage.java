package package_model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LacostaHomePage {
    private static final String HOMEPAGE_URL = "https://lacoste.ru/";
    private WebDriver  driver;
    private WebElement keyPress;

    @FindBy(xpath = "//*[@id='search-render']/form/input[1]")
    private WebElement searchInput;

    public LacostaHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public  LacostaHomePage openPage()
    {
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
        return this;
    }
     public searchResultsWithParameter searchForTerms(String term)
     {
         searchInput.sendKeys(term);
         searchInput.sendKeys(Keys.ENTER);
         return new searchResultsWithParameter(driver,term);
     }

}
