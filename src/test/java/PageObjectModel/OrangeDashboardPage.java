package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeDashboardPage {
    private WebDriver driver;
    private By userInfo= By.xpath("//h6[text()='Dashboard']");
    private By timerIcon=By.xpath("//i[@class='oxd-icon bi-stopwatch']");
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
}
