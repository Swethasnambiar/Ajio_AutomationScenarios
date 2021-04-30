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

public class AddToBag {

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

            System.out.println("test");
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div/div[1]")).click();
            driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/form/div/div/input")).sendKeys("jackets");
            driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/form/div/div/input")).sendKeys(Keys.RETURN);
            String parentHandle = driver.getWindowHandle();
            driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div[1]/div/div[1]/a/div/div[1]/img")).click();
            Thread.sleep(3000);
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
            }
            driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[2]/div/div/div[2]/div/div[3]/div/div[6]/div[2]/div/div/div[4]/div")).click();
            driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[2]/div/div/div[2]/div/div[3]/div/div[9]/div[1]/div[1]/div/span[2]")).click();
            Thread.sleep(3000);
            TakesScreenshot tc = (TakesScreenshot) driver;
            File src = tc.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File("C://MY EY//Selenium//Drivers//Addtobag.png"));
        }
    }
    @AfterTest
    public void CloseBrowser() {
      driver.close();
    }

}

