package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeLeavePage {
    private WebDriver driver;

    private By assignLeaveTabText=By.xpath("//h6[normalize-space()='Assign Leave']");
    private By leaveListTabText=By.xpath("//h5[normalize-space()='Leave List']");
    private By applyLeaveTabText=By.xpath("//h6[normalize-space()='Apply Leave']");
    private By myLeaveListTabText=By.xpath("//h5[normalize-space()='My Leave List']");

    public OrangeLeavePage(WebDriver driver){
        this.driver=driver;
    }
    public String getAssignLeaveTabText(){
        return driver.findElement(assignLeaveTabText).getText();
    }
    public String getLeaveListTabText(){
        return driver.findElement(leaveListTabText).getText();
    }
    public String getApplyLeaveTabText(){
        return driver.findElement(applyLeaveTabText).getText();
    }
    public String getMyLeaveListTabText(){
        return driver.findElement(myLeaveListTabText).getText();
    }

}
