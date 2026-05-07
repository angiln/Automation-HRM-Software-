package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeDashboardPage {
    private WebDriver driver;
    private By userInfo= By.xpath("//h6[text()='Dashboard']");
    public  OrangeDashboardPage(WebDriver driver){
        this.driver=driver;
    }
    public By getUserInfo(){
        return userInfo;
    }
    public String dashboardPageConfirmer() {
       return  driver.findElement(getUserInfo()).getText();
    }
}
