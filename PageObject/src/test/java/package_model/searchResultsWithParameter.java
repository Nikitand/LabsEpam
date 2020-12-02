package package_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class searchResultsWithParameter {
    private WebDriver driver;
    private String searchTerm;

    @FindBy(className = "search-result-items")
    private List<WebElement> generalSearchResult;

    @FindBy(xpath = "//*[@id='content-container']//div[1]/div[2]//form/div[1]//button")
    private WebElement genderCheckbox;

    @FindBy(xpath = "//*[@id='content-container']//div[2]//div[2]//div[3]")
    private WebElement menCheckbox ;

    @FindBy(xpath = "//*[@id='content-container']//div/div/div/div/div/div[2]/section/div/div/div[1]/div[2]/div/div/form/div[2]/div/button")
    private WebElement sessionCheckbox ;

    @FindBy(xpath = "//*[@id='content-container']//div[2]//form/div[2]//div[2]")
    private WebElement winterCheckBox;

    @FindBy(xpath = "//*[@id='content-container']//div/div/div/div/div/div[2]/section/div/div/div[1]/div[2]/div/div/form/div[6]/div/button")
    private WebElement sizeCheckbox;

    @FindBy(xpath = "//*[@id='content-container']//div[2]//div[6]//div[2]")
    private WebElement oneSizeCheckbox;

    @FindBy(xpath = "//*[@id='content-container']//div/div/div/div/div/div[2]/section/div/div/div[1]/div[2]/div/div/form/div[7]/div/button")
    private WebElement cityCheckbox;

    @FindBy(xpath = "//*[@id='content-container']//section//div[2]//form/div[7]/div/div[1]/div[2]")
    private WebElement moskowcityCheckbox;


    public searchResultsWithParameter(WebDriver driver, String searchTerm)
    {
        this.searchTerm = searchTerm;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public searchResultsWithParameter() {
        this.driver = driver;
    }

    public searchResultsWithParameter addParametrs() {
        waitForElementToBeClickable(this.driver, By.className("filter-left"));
        this.genderCheckbox.click();
        this.menCheckbox.click();
        this.sessionCheckbox.click();
        this.winterCheckBox.click();
        this.sizeCheckbox.click();
        this.oneSizeCheckbox.click();
        this.cityCheckbox.click();
        this.moskowcityCheckbox.click();
        return new searchResultsWithParameter();
    }
    public int countGeneralNumberOfSearchResults()
    {
        System.out.println("Number of results:" + generalSearchResult.size());
        return  generalSearchResult.size();
    }
    public int countNumberOfSearchResult() {
        List<WebElement> resultsNumberWithSearchTerm = driver.findElements(By.id(""));
        System.out.println("Search result number for requested term:" + resultsNumberWithSearchTerm.size());
        return resultsNumberWithSearchTerm.size();
    }

    private WebElement waitForElementToBeClickable(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .elementToBeClickable(by));
    }
}
