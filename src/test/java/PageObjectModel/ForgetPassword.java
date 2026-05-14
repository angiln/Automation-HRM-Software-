package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPassword {
    private WebDriver driver;
    private By resetPassword=By.xpath("//h6[normalize-space()='Reset Password']");
    public ForgetPassword(WebDriver driver){
        this.driver=driver;
    }
    public By getResetPassword(){
        return resetPassword;
    }
    public String resetPasswordConfirm(){
        return driver.findElement(getResetPassword()).getText();
    }
}
