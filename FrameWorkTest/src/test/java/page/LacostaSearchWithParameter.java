package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LacostaSearchWithParameter extends AbstractPage{

    public LacostaSearchWithParameter(WebDriver driver) {
        super(driver);
    }

    private final String checkResult="//div [@class= \"search-plug__inner\"]/ h2";
    private final String genderLocator="//button[contains(text(),'Пол')]";
    private final String menGenderLocator="//label[contains(text(),'Муж')]";
    private final String seasonLocator="//button[contains(text(),'Сезон')]";
    private final String winterSeasonLocator="//label[contains(text(), \"зима\") and @class =\"filterbtn\"]";
    private final String sizeLocator="//button[contains(text(),'Размер') and @ class=\"extern-fit nav-ico-after\"]";
    private final String fourtySixeSizeLocator="//label[contains(text(),'46')]";

    @FindBy(xpath = "//ul [@id= \"search-result-items\"]")
    private List<WebElement> generalSearchResult;

    public  LacostaSearchWithParameter selectGenger(){
        clickButtonByXpath(By.xpath(genderLocator));
        clickButtonByXpath(By.xpath(menGenderLocator));
        return this;
    }

    public LacostaSearchWithParameter selectSeason(){
        clickButtonByXpath(By.xpath(seasonLocator));
        clickButtonByXpath(By.xpath(winterSeasonLocator));
        return this;
    }

    public LacostaSearchWithParameter selectSize(){
        clickButtonByXpath(By.xpath(sizeLocator));
        clickButtonByXpath(By.xpath(fourtySixeSizeLocator));
        return this;
    }

    public int countGeneralNumberOfSearchResults()
    {
        System.out.println("Number of results:" + generalSearchResult.size());
        return  generalSearchResult.size();
    }
    public int countResultsNumberWithSearchTerm()
    {
        List<WebElement> resultsNumberWithSearchTerm = driver.findElements(By.id(""));
        System.out.println("Search result number for requested term:" + resultsNumberWithSearchTerm.size());
        return resultsNumberWithSearchTerm.size();
    }
}
