package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeLoginPage {
    private WebDriver driver;
    private By userElement = By.xpath("//input[@name='username']");
    private By passwordElement = By.xpath("//input[@name='password']");
    private By submitElement = By.xpath("//button[@type='submit']");
    private By requiredElement=By.xpath("//span[text()='Required']");
    private By invalidCredentials=By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
    private By forgetPasswordLink=By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p");

    public OrangeLoginPage(WebDriver driver){
        this.driver=driver;

    }
    public By getUserElement(){
        return userElement;
    }
    public By getPasswordElement(){
        return passwordElement;
    }
    public By getSubmitElement(){
        return submitElement;
    }
    public void loggerApp(String Username , String Password){
        driver.findElement(getUserElement()).sendKeys(Username);
        driver.findElement(getPasswordElement()).sendKeys(Password);
        driver.findElement(getSubmitElement()).click();

    }
    public By getRequiredElement(){
        return requiredElement;
    }
    public String getOneRequiredElement(){
        return driver.findElement(requiredElement).getText();

    }
    public By getInvalidCredentials(){
        return invalidCredentials;
    }

    public String InvalidCredentialConfirmer(){
        return driver.findElement(getInvalidCredentials()).getText();
    }
    public By getForgetPasswordLink(){
        return forgetPasswordLink;

    }
    public void redirectToForgetPassword(){
        driver.findElement(getForgetPasswordLink()).click();
    }
}
