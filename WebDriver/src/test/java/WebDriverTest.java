import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebDriverTest {

    private WebDriver driver;

    private static final int TIME_OUT_SECONDS = 25;

    @BeforeTest
  public   void start()  {
        driver = new ChromeDriver();
    }

    @Test
    public void searchWithParametrs()  {
        driver.get("https://lacoste.ru/");
        driver.manage().window().maximize();

        WebElement searchInput = driver.findElement(By.xpath("//input[@class='q' and @itemprop='query-input']\n"));
        searchInput.sendKeys("КУРТКА");
        searchInput.sendKeys(Keys.ENTER);

        clickButtonByXpath(By.xpath("//button[contains(text(),'Пол')]"));
        clickButtonByXpath(By.xpath("//label[contains(text(),'Муж')]"));
        clickButtonByXpath(By.xpath("//button[contains(text(),'Сезон')]"));
        clickButtonByXpath(By.xpath("//label[contains(text(), \"зима\") and @class =\"filterbtn\"]"));
        clickButtonByXpath(By.xpath("//button[contains(text(),'Размер') and @ class=\"extern-fit nav-ico-after\"]"));
        clickButtonByXpath(By.xpath("//label[contains(text(),'46')]"));
        clickButtonByXpath(By.xpath("//button[contains(text(),'Наличие')]"));
        clickButtonByXpath(By.xpath("//label[contains(text(),'Вегас, Москва')]"));



        List<WebElement> searchResult = driver.findElements(By.id("search-result-items"));
        Assert.assertTrue("search result are empty!", searchResult.size()>0);
    }

    @AfterTest(alwaysRun = true)
    public void finish()   {
        driver.quit();
    }
    private void clickButtonByXpath(By by) {
        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .click();
    }
}