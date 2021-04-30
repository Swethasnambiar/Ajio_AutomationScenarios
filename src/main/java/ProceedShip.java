import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class ProceedShip {
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

            //System.out.println("test");
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
           driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/div/div[3]/div/div[9]/div[1]/div[1]/a/div/span[2]")).click();
           driver.findElement(By.xpath("//*[@id=\"dCartWrapper\"]/div[2]/div[2]/div[2]/div[2]/button")).click();
          //  driver.findElement(By.xpath("//*[@id=\"dCartWrapper\"]/div[2]/div[2]/div[2]/div[2]/button")).click();

            String TestEmail = driver.findElement(By.xpath("//*[@id=\"login-modal\"]/div/div/div[2]/div/form/div[2]/div[1]/label")).getText();


           // System.out.println(TestEmail);
            if(TestEmail.equals("Enter Mobile Number / Email*")) {
                //System.out.println("inside");
                Thread.sleep(3000);



                TakesScreenshot tc = (TakesScreenshot) driver;
                File src = tc.getScreenshotAs(OutputType.FILE);
                FileHandler.copy(src, new File("C://MY EY//Selenium//Drivers//ProcedShip.png"));
            }



        }
    }
    @AfterTest
    public void CloseBrowser() {
         driver.close();
    }

}

