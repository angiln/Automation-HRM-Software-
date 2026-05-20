package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrangeAdminPage {
    private WebDriver driver;
    private By adminTextHeader=By.xpath("//span[contains(@class,'oxd-topbar-header-breadcrumb')]");
    private By topBodyNavItem=By.xpath("//span[contains(@class,'oxd-topbar-body-nav-tab-item')]");
    private By userManagementDropdown=By.xpath("//a[contains(text(),'Users')]");
    private By  userNameTextArea=By.xpath("(//input[contains(@class,'oxd-input oxd-input--active')])[2]");
    private By userRole=By.xpath("(//div[contains(@class,'oxd-select-text oxd-select-text--active')])[1]");
    private By userRoleOptions=By.xpath("//div[contains(@class,'oxd-select-option')]");
    private By employeeNameElement=By.xpath("//input[contains(@placeholder,'Type for hints')]");
    private By status=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]");
    private By statusOptions=By.xpath("//div[@role='option']");
   private By searchButtonAdmin=By.xpath("//button[contains(@class,'orangehrm-left-space')]");


    public OrangeAdminPage(WebDriver driver){
        this.driver=driver;
    }
    public String getAdminTextHeader(){
        return driver.findElement(adminTextHeader).getText();

    }
    public By getTopBarBodyNavItem(){
        return topBodyNavItem;
    }
    public void clickOnUserManagementDropDown(){
        driver.findElement(userManagementDropdown).click();
    }
    public void setUserName(String username){
        driver.findElement(userNameTextArea).sendKeys(username);

    }
    public void clickOnUserRole(){
        driver.findElement(userRole).click();
    }
    public List<WebElement> getUserRole(){
        return driver.findElements(userRoleOptions);
    }
    public void setEmployeeNameElement(String employeename){
        driver.findElement(employeeNameElement).sendKeys(employeename);
    }
    public void clickOnStatus(){
        driver.findElement(status).click();
    }
    public List<WebElement> getStatusOptions(){
        return driver.findElements(statusOptions);
    }

    public void searchAdminClicker(){
        driver.findElement(searchButtonAdmin).click();
    }
}
