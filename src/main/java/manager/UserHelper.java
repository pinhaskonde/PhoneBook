package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegForm() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    public void fillLoginRegForm(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }

    public void clickLoginButton() {
        click(By.xpath("//button[1]"));
    }

    public void acceptAlert() {
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert().accept();
    }

    public boolean isLogged() {
        return wd.findElements(By.xpath("//button[text()='Sign Out']")).size()>0;
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }
}