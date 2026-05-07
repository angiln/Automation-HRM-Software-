package testData;



import PageObjectModel.ForgetPassword;
import PageObjectModel.OrangeDashboardPage;
import PageObjectModel.OrangeLoginPage;
import driverSetter.driverSet;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrangeLogin {
    private WebDriver driver;
    private OrangeLoginPage loginpage;
    private OrangeDashboardPage dashboardPage;
    private ForgetPassword forgetPassword;

    @BeforeEach
    private void driverSetup(){
        driver=new driverSet().getDriver();
        loginpage=new OrangeLoginPage(driver);
        dashboardPage = new OrangeDashboardPage(driver);
        forgetPassword = new ForgetPassword(driver);

    }
    @AfterEach
    private void driverTear(){
        driver.quit();
    }
    @Test
    public void correctUsernameCorrectPassword(){
        loginpage.loggerApp("Admin","admin123");
        Assertions.assertEquals("Dashboard",dashboardPage.dashboardPageConfirmer());
    }
    @Test
    public void wrongUsernameCorrectPassword(){
        loginpage.loggerApp("***","admin123");
        Assertions.assertEquals("Invalid credentials",loginpage.InvalidCredentialConfirmer());

    }
    @Test
    public void correctUsernameWrongPassword(){
        loginpage.loggerApp("Admin","***");
        Assertions.assertEquals("Invalid credentials",loginpage.InvalidCredentialConfirmer());
    }
    @Test
    public void wrongUsernameWrongPassword(){
        loginpage.loggerApp("***","***0");
        Assertions.assertEquals("Invalid credentials",loginpage.InvalidCredentialConfirmer());
    }
    @Test
    public void blankUsernameBlankPassword(){
        loginpage.loggerApp(" "," ");
        List<WebElement> elements=driver.findElements(loginpage.getRequiredElement());
        for(WebElement element:elements){
            Assertions.assertEquals("Required",element.getText());
            Assertions.assertEquals("Required",element.getText());
        }

    }
    @Test
    public void correctCapitalUsernameCorrectCapitalPassword(){
        loginpage.loggerApp("ADMIN","ADMIN123");
        Assertions.assertEquals("Invalid credentials",loginpage.InvalidCredentialConfirmer());

    }
    @Test
    public void correctCapitalUsernameCorrectSmallPassword(){
        loginpage.loggerApp("ADMIN","admin123");
        Assertions.assertEquals("Dashboard",dashboardPage.dashboardPageConfirmer());

    }
    @Test
    public void wrongCapitalUsernameWrongCapitalPassword(){
        loginpage.loggerApp("ANDHADHUND","ANDHADHUND");
        Assertions.assertEquals("Invalid credentials",loginpage.InvalidCredentialConfirmer());
    }
    @Test
    public void correctSmallUsernameCorrectSmallPassword(){
        loginpage.loggerApp("admin","admin123");
        Assertions.assertEquals("Dashboard",dashboardPage.dashboardPageConfirmer());
    }
    @Test
    public void usernameOnly(){
        loginpage.loggerApp("Admin"," ");
//        List<WebElement> elements1= (List<WebElement>) driver.findElement(loginpage.getRequiredElement());
//        for(WebElement element:elements1){
//            Assertions.assertEquals("Required",element.getText());
//        }
        Assertions.assertEquals("Required",loginpage.getOneRequiredElement());
    }
    @Test
    public void passwordOnly(){
        loginpage.loggerApp("","admin123");
//        List<WebElement> elements1= (List<WebElement>) driver.findElement(loginpage.getRequiredElement());
//        for(WebElement element:elements1){
//            Assertions.assertEquals("Required",element.getText());
//        }

       Assertions.assertEquals("Required",loginpage.getOneRequiredElement());
    }
    @Test
    public void clicOnforgetPassword(){
        loginpage.redirectToForgetPassword();
        Assertions.assertEquals("Reset Password",forgetPassword.resetPasswordConfirm());
    }

}
