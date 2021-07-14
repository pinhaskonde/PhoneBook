import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginTestPositive(){
        click(By.xpath("//a[text()='LOGIN']"));
        type(By.xpath("//input[@placeholder='Email']"),"sofa@gmail.com");
        type(By.xpath("//input[@placeholder='Password']"),"Sofa123$");
        click(By.xpath("//button[.=' Login']"));
        pause(3000);
        String loginSuccess = getText(By.xpath("//button[.='Sign Out']"));
        Assert.assertEquals(loginSuccess,"Sign Out");
    }


}
