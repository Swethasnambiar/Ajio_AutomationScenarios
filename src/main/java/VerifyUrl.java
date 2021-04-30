import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class VerifyUrl {
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
            String MenUrL = "https://www.ajio.com/shop/men";
            String WomenUrl = "https://www.ajio.com/shop/women";
            String KidUrl = "https://www.ajio.com/shop/kids";
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div/div[1]")).click();
            driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[1]/ul/li[1]/a")).click();
            String currentURL1 = driver.getCurrentUrl();
            driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[1]/ul/li[2]/a")).click();
            String currentURL2 = driver.getCurrentUrl();
            driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[1]/ul/li[3]/a")).click();
            String currentURL3 = driver.getCurrentUrl();
          //  System.out.println(currentURL1);
           // System.out.println(currentURL2);
           // System.out.println(currentURL3);
            if(MenUrL.equals(currentURL1) && WomenUrl.equals(currentURL2)&& KidUrl.equals(currentURL3)) {
                TakesScreenshot tc = (TakesScreenshot) driver;
                File src = tc.getScreenshotAs(OutputType.FILE);
                FileHandler.copy(src, new File("C://MY EY//Selenium//Drivers//Verifyurl.png"));
            }
            else
            {
                System.out.println("URL is not changing");
            }

        }
    }
    @AfterTest
    public void CloseBrowser() {

        driver.close();

    }

}
