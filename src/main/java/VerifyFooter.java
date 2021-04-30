import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import java.io.File;
import java.io.PrintStream;
import java.util.List;

public class VerifyFooter {

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

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            List<WebElement> allElements = driver.findElements(By.xpath("//*[@id=\"appContainer\"]/div[3]/footer/div[2]/div/div[1]/section[1]/div[2]"));
            //String[] strArray = { "Who We Are", "Join Our Team", "Terms & Conditions","We Respect Your Privacy","Fees & Payments","Returns & Refunds Policy","Promotions Terms & Conditions"};
            String[] strArray = { "Who We AreJoin Our TeamTerms & ConditionsWe Respect Your PrivacyFees & PaymentsReturns & Refunds PolicyPromotions Terms & Conditions"};
            int i=0;
            for (WebElement element: allElements) {

                System.out.println(element.getText());
                if (strArray[i].equals(element.getText()))
                {
                    System.out.println("Menu items match");
                }
                else
                {System.out.println("Not Matching");}
                i=i+1;


            }
            System.out.println(i);
            if (i==1)
            {
                TakesScreenshot tc = (TakesScreenshot) driver;
                File src = tc.getScreenshotAs(OutputType.FILE);
                FileHandler.copy(src, new File("C://MY EY//Selenium//Drivers//verifyFooter.png"));

            }
        }
    }
    @AfterTest
    public void CloseBrowser() {
        driver.close();
    }

}
