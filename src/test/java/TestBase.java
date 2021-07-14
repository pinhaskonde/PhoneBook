import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app");
    }

    @AfterClass
    public void tearDown(){
        wd.quit();
    }

    public void pause(int mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public  void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator){
        return wd.findElement(locator).getText();
    }

    public boolean isExists(String locator, String text){
        if(locator != null){
            WebElement element = wd.findElement(By.xpath(locator));
        }
        return false;
    }

}
