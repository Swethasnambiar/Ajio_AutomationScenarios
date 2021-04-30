import org.testng.annotations.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import java.io.File;
public class SearchProduct {

    public WebDriver driver;

    @BeforeTest
    public void OpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "C://MY EY//Selenium//Drivers/chromedriver.exe");
        // WebDriver driver =new ChromeDriver();
        this.driver = new ChromeDriver();
        driver.get("https://www.ajio.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void SearchP() throws Exception {

        {

            System.out.println("Test_searchproduct");
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div/div[1]")).click();
            driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/form/div/div/input")).sendKeys("Jackets");
            driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/form/div/div/input")).sendKeys(Keys.RETURN);
            TakesScreenshot tc = (TakesScreenshot) driver;
            File src = tc.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File("C://MY EY//Selenium//Drivers//Avialable.png"));
        }
    }
    @AfterTest
    public void CloseBrowser() {
        System.out.println("afterTest_searchproduct");
        driver.close();

    }

}
