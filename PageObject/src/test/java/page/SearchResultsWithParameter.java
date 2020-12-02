package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsWithParameter {
    private WebDriver driver;
    private String searchTerm;
    static int WAIT_TIMEOUT_SECOND = 15;
    @FindBy(className = "products reveal")
    private List<WebElement> generalSearchResult;


    private final By genderCheckboxLocator = By.xpath("//*[@id='content-container']//div[1]/div[2]//form/div[1]//button");

    private final By menCheckboxLocator = By.xpath("//*[@id='content-container']//div[2]//div[2]//div[3]");

    private final By sessionCheckboxLocator = By.xpath("//*[@id='content-container']//div[2]/section/div/div/div[1]/div[2]/div/div/form/div[2]/div/button");

    private final By winterCheckBoxLocator = By.xpath("//*[@id='content-container']//div[2]//form/div[2]//div[2]");

    private final By sizeCheckboxLocator = By.xpath("//*[@id='content-container']//div[2]/section/div/div/div[1]/div[2]/div/div/form/div[6]/div/button");

    private final By oneSizeCheckboxLocator = By.xpath("//*[@id='content-container']//div[2]//div[6]//div[2]");

    private final By cityCheckboxLocator = By.xpath("//*[@id='content-container']//div[2]/section/div/div/div[1]/div[2]/div/div/form/div[7]/div/button");

    private final By moskowcityCheckboxLocator = By.xpath("//*[@id='content-container']//section//div[2]//form/div[7]/div/div[1]/div[2]");


    public SearchResultsWithParameter(WebDriver driver, String searchTerm) {
        this.searchTerm = searchTerm;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchResultsWithParameter() {
        this.driver = driver;
    }

    public SearchResultsWithParameter addParametrs() {
        WebElement genderCheckbox = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(genderCheckboxLocator));
        genderCheckbox.click();
        WebElement menCheckbox = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(menCheckboxLocator));
        menCheckbox.click();
        WebElement sessionCheckbox = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(sessionCheckboxLocator));
        sessionCheckbox.click();
        WebElement winterCheckBox = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(winterCheckBoxLocator));
        winterCheckBox.click();
        WebElement sizeCheckbox = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(sizeCheckboxLocator));
        sizeCheckbox.click();
        WebElement oneSizeCheckbox = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(oneSizeCheckboxLocator));
        oneSizeCheckbox.click();
        WebElement cityCheckbox = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(cityCheckboxLocator));
        cityCheckbox.click();
        WebElement moskowcityCheckbox = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND )
                .until(ExpectedConditions.presenceOfElementLocated(moskowcityCheckboxLocator));
        moskowcityCheckbox.click();
        return this;
    }

    public int countGeneralNumberOfSearchResults() {
        System.out.println("Number of results:" + generalSearchResult.size());
        return generalSearchResult.size();
    }

    public int countNumberOfSearchResult() {
        List<WebElement> resultsNumberWithSearchTerm = driver.findElements(By.id("search-result-items"));
        System.out.println("Search result number for requested term:" + resultsNumberWithSearchTerm.size());
        return resultsNumberWithSearchTerm.size();
    }
}
