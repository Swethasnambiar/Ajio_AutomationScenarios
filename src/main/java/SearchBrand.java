import org.testng.annotations.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import javax.lang.model.element.VariableElement;
import java.io.File;

public class SearchBrand {

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
            driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/form/div/div/input")).sendKeys("PUMA");
            driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/form/div/div/input")).sendKeys(Keys.RETURN);
            String brands = "Puma";
            String brandname= driver.findElement(By.xpath("//*[@id=\"products\"]/div[1]/h1/div[2]")).getText();
            brandname.trim();
            if (brandname.equals(brands))
            {  System.out.println("insideif");
                TakesScreenshot tc = (TakesScreenshot) driver;
                File src = tc.getScreenshotAs(OutputType.FILE);
                FileHandler.copy(src, new File("C://MY EY//Selenium//Drivers//Searchbrand.png"));
            }
            else
            {
                System.out.println(brandname);
            }
        }
    }
    @AfterTest
    public void CloseBrowser() {
       //System.out.println("afterTest_searchproduct");
      driver.close();

    }

}
