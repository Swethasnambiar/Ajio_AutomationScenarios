import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import java.io.File;
import java.io.PrintStream;
import java.util.List;

public class VerifyMenu {

    public WebDriver driver;

    @BeforeTest
    public void OpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "C://MY EY//Selenium//Drivers/chromedriver.exe");
        // WebDriver driver =new ChromeDriver();
        this.driver = new ChromeDriver();
        driver.get("https://www.ajio.com/");
    }

    @Test
    public void SearchP() throws Exception {

        {


            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div/div[1]")).click();

            List<WebElement> allElements = driver.findElements(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[1]/ul/li"));
            String[] strArray = { "MEN", "WOMEN", "KIDS", "INDIE", "HOME AND KITCHEN", "NEW ARRIVALS"};
            int i=0;
            for (WebElement element: allElements) {

               //System.out.println(element.getText());
                if (strArray[i].equals(element.getText()))
                {
                    System.out.println("Menu items match");
                }
                else
                {System.out.println("Not Matching");}
                i=i+1;


            }
            System.out.println(i);
            if (i==6)
            {
                TakesScreenshot tc = (TakesScreenshot) driver;
                File src = tc.getScreenshotAs(OutputType.FILE);
                FileHandler.copy(src, new File("C://MY EY//Selenium//Drivers//verifymenu.png"));

            }
        }
    }
    @AfterTest
    public void CloseBrowser() {
        driver.close();
    }

}
