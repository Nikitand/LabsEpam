import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebdriverTestTest {
    WebDriver driver;
    Actions moveToButton;
    WebDriverWait wait;
    @BeforeTest
    void Start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 25);
    }
    @Test
    public void searchWithParametrs()
    {
        driver.get("https://lacoste.ru/");
        driver.manage().window().maximize();
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='search-render']/form/input[1]"));
        searchInput.sendKeys("КУРТКА");
        searchInput.sendKeys(Keys.ENTER);
        WebElement genderCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content-container']//div[1]/div[2]//form/div[1]//button")));
        genderCheckbox.click();
        WebElement menCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content-container']//div[2]//div[2]//div[3]")));
        menCheckbox.click();
        WebElement sessionCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content-container']//div/div/div/div/div/div[2]/section/div/div/div[1]/div[2]/div/div/form/div[2]/div/button")));
        sessionCheckbox.click();
        WebElement winterCheckBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content-container']//div[2]//form/div[2]//div[2]")));
        winterCheckBox.click();
        WebElement sizeCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content-container']//div/div/div/div/div/div[2]/section/div/div/div[1]/div[2]/div/div/form/div[6]/div/button")));
        sizeCheckbox.click();
        WebElement oneSizeCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content-container']//div[2]//div[6]//div[2]")));
        oneSizeCheckbox.click();
        WebElement cityCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content-container']//div/div/div/div/div/div[2]/section/div/div/div[1]/div[2]/div/div/form/div[7]/div/button")));
        cityCheckbox.click();
        WebElement moskowcityCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content-container']//section//div[2]//form/div[7]/div/div[1]/div[2]")));
        moskowcityCheckbox.click();

    }
    @AfterTest(alwaysRun = true)
    void Finish()
    {
        driver.quit();
    }
}