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
    private WebDriverWait wait;

    static   int TIME_OUT_SECONDS = 25;

    @BeforeTest
    void start()  {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, TIME_OUT_SECONDS);
            }
    @Test
    public void searchWithParametrs()
    {
        driver.get("https://lacoste.ru/");
        driver.manage().window().maximize();

        WebElement searchInput = driver.findElement(By.xpath("//*[@id='search-render']/form/input[1]"));
        searchInput.sendKeys("КУРТКА");
        searchInput.sendKeys(Keys.ENTER);

        WebElement genderCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Пол')]")));
        genderCheckbox.click();
        WebElement menCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content-container']//div[2]//div[2]//div[3]")));
        menCheckbox.click();
        WebElement sessionCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Сезон')]")));
        sessionCheckbox.click();
        WebElement winterCheckBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content-container']//div[2]//form/div[2]//div[2]")));
        winterCheckBox.click();
        WebElement sizeCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Цвет')]")));
        sizeCheckbox.click();
        WebElement oneSizeCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content-container']//div[2]//div[6]//div[2]")));
        oneSizeCheckbox.click();
        WebElement cityCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Наличие')]")));
        cityCheckbox.click();
        WebElement moskowcityCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Вегас, Москва')]")));
        moskowcityCheckbox.click();

        List<WebElement> searchResult = driver.findElements(By.id("search-result-items"));
        Assert.assertTrue("search result are empty!", searchResult.size()>0);


    }
    @AfterTest(alwaysRun = true)
    void finish()
    {

        driver.quit();
    }
}