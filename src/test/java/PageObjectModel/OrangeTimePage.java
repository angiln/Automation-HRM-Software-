package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeTimePage {
    private WebDriver driver;
    private By attendanceText=By.xpath("//h6[normalize-space()='Attendance']");
    private By timeText=By.xpath("//h6[contains(@class, 'orangehrm-main-title')]");
    public OrangeTimePage(WebDriver driver){
        this.driver=driver;
    }
    public By getAttendanceTextBy(){
        return attendanceText;
    }
    public String getAttendanceText(){
        return driver.findElement(attendanceText).getText();
    }public String getMainTitle(){
        return driver.findElement(timeText).getText();
    }

}
