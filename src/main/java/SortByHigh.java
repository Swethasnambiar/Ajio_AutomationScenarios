import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import java.io.File;
import java.io.PrintStream;
import java.util.List;


public class SortByHigh {
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


            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div/div[1]")).click();
            driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/form/div/div/input")).sendKeys("Shoes");
            driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/form/div/div/input")).sendKeys(Keys.RETURN);

            driver.findElement(By.xpath("//*[@id=\"products\"]/div[2]/div/div[3]/div/select/option[3]")).click();
            String value1 = driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div[1]/div/div[1]/a/div/div[2]/div[3]/span")).getText().substring(4).replace(",","");
            String value2 = driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div[1]/div/div[2]/a/div/div[2]/div[3]/span")).getText().substring(4).replace(",","");
            //System.out.println(value1);
           // System.out.println(value2);
           int price1 = Integer.parseInt(value1);
           int price2 = Integer.parseInt(value2);
         //  System.out.println(price1);
          // System.out.println(price2);

            if (price1>price2)

            {
                TakesScreenshot tc = (TakesScreenshot) driver;
                File src = tc.getScreenshotAs(OutputType.FILE);
                FileHandler.copy(src, new File("C://MY EY//Selenium//Drivers//sortbyhigh.png"));
            }
            else {
                System.out.println("Sort is not proper");
            }

        }
    }
    @AfterTest
    public void CloseBrowser() {
        driver.close();

    }

}
