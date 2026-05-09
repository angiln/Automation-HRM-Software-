package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeDashboardPage {
    private WebDriver driver;
    private By userInfo= By.xpath("//h6[text()='Dashboard']");
    private By timerIcon=By.xpath("//i[@class='oxd-icon bi-stopwatch']");
    private By myActionTab1stIcon=By.xpath("//*[name()='path' and contains(@d,'M5105 7409')]");
    private By myActionTab2ndIcon=By.xpath("(//button[contains(@class,'orangehrm-report-icon')])[2]");
    private By quickLaunchMenu=By.xpath("//div[contains(@class,'orangehrm-quick-launch-card')]");
    private By buzzLatestPost=By.xpath("//div[contains(@class,'orangehrm-buzz-widget')]");
    private By buzzPostUser=By.xpath("//div[contains(@class,'orangehrm-buzz-widget-header-text')]");
    public  OrangeDashboardPage(WebDriver driver){
        this.driver=driver;
    }
    public By getUserInfo(){
        return userInfo;
    }
    public String dashboardPageConfirmer() {
       return  driver.findElement(getUserInfo()).getText();
    }
    public By getTimerIcon(){
        return timerIcon;
    }
    public WebElement clickTimerIcon(){
        return driver.findElement(timerIcon);
    }

    public void clickMyActionPage1stIcon(){
         driver.findElement(myActionTab1stIcon).click();
    }
    public void clickMyActionTab2ndIcon(){
        driver.findElement(myActionTab2ndIcon).click();
    }
    public By getQuickLaunchMenu(){
        return quickLaunchMenu;
    }
    public By getBuzzLatestPost(){
        return buzzLatestPost;
    }
    public void clickOnBuzzPostUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(buzzPostUser).click();
    }
}
