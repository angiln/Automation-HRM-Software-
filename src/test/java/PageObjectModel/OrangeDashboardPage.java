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
    private By employeesOnLeaveSettingIcon= By.xpath("//i[contains(@class,'orangehrm-leave-card-icon')]");
    private By employeesOnLeavePromptText=By.xpath("//p[text()='Configurations']");
    private By employeesPromptCloseIcon=By.xpath("//button[contains(@class,'oxd-dialog-close-button-position')]");
    private By firstPieChartElements=By.xpath(".");

    private By upgradeButtonElement=By.xpath("//button[contains(@class,'orangehrm-upgrade-button')]");
    private By userIcon=By.xpath("//li[contains(@class,'oxd-userdropdown')]");
    private By helpIcon=By.xpath("//button[contains(@title,'Help')]");
    private By footerLink=By.xpath("//a[@href='http://orangehrm.com']");
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
    public void clickOnEmployeesOnLeaveSetting(){
        driver.findElement(employeesOnLeaveSettingIcon).click();

    }
    public String getEmployeesOnLeavePromptText(){
        return driver.findElement(employeesOnLeavePromptText).getText();
    }
    public void employeesOnLeavePromptCloser(){
        driver.findElement(employeesPromptCloseIcon).click();
    }
    public By getFirstPieChartElements(){
        return firstPieChartElements;
    }
    public void clickOnUpgradeButton(){
        driver.findElement(upgradeButtonElement).click();
    }
    public By getUserIcon(){
        return userIcon;
    }
    public void clickOnUserIcon(){
        driver.findElement(userIcon).click();
    }
    public void clickOnHelpIcon(){
        driver.findElement(helpIcon).click();
    }
    public void clickOnFooterOHRMlink(){
        driver.findElement(footerLink).click();
    }

}
