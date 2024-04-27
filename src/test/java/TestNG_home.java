import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class TestNG_home {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass (alwaysRun = true)
    public void home(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dou.ua/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterClass (alwaysRun = true)
    public void tearDown(){
        if (driver!=null)
        driver.quit();
    }

    @Test
    void first (){
        String title = driver.getTitle();
        assertTrue(wait.until(ExpectedConditions.titleContains("DOU")));
    }


    @Test
    //Перевіряемо чи є Англійська локаль на сайті
    void second (){
        WebElement local = driver.findElement(By.cssSelector("div.col18.m-db >p>a"));
        local.click();
        WebElement englocal = driver.findElement(By.className("sel"));
    }

    @Test
    // Перевіряемо що пошук працюе - і є результати
    void third(){
        WebElement serch = driver.findElement(By.xpath("//*[@id=\"txtGlobalSearch\"]"));
        serch.click();
        serch.sendKeys("test");
        serch.sendKeys(Keys.ENTER);
        WebElement result = driver.findElement(By.id("resInfo-0"));
    }

    @Test
    // Шукаемо яка нині зарплати у QA та її медіану
    void fourth(){
        WebElement money = driver.findElement(By.cssSelector("header>ul>li:nth-child(5)>a"));
        money.click();
        WebElement sort = driver.findElement(By.xpath("//*[@id=\"dd-position\"]"));
        sort.click();
        WebElement find = driver.findElement(By.cssSelector("div:nth-child(2)>div.positons-list>div:nth-child(4)"));
        find.click();
        WebElement resuls = driver.findElement(By.id("median"));
    }

    @Test
    // Перевіряемо що при пошуку роботи є результат
    void five (){
        WebElement page = driver.findElement(By.cssSelector("header>ul>li:nth-child(6)>a"));
        page.click();
        WebElement categor = driver.findElement(By.cssSelector("div.b-jobs-search>form>select"));
        categor.click();
        categor.sendKeys("QA" + Keys.ENTER);
        WebElement categor2 = driver.findElement(By.cssSelector("div:nth-child(3)>div>div>ul:nth-child(2)>li:nth-child(5)>a"));
        categor2.click();
        WebElement result = driver.findElement(By.className("b-inner-page-header"));
    }
}
