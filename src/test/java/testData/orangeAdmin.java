package testData;

import PageObjectModel.OrangeAdminPage;
import PageObjectModel.OrangeDashboardPage;
import PageObjectModel.OrangeLoginPage;
import driverSetter.driverSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class orangeAdmin {
    private WebDriver driver;
    private OrangeAdminPage adminPage;
    private OrangeLoginPage loginpage;
    private OrangeDashboardPage dashboardPage;
    @BeforeEach
    public void driverSet(){
        driver=new driverSet().getDriver();
        adminPage=new OrangeAdminPage(driver);
        loginpage=new OrangeLoginPage(driver);
        dashboardPage=new OrangeDashboardPage(driver);
        loginpage.loggerApp("Admin","admin123");
    }
    @AfterEach
    public void killDriver(){
        driver.quit();
    }
    @Test
    public void navigateToAdminPageFromMenu(){
        dashboardPage.setSearchDashboard("Admin");
        driver.findElement(dashboardPage.getMenuItems()).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        Assertions.assertEquals("Admin\n" +
                "User Management",adminPage.getAdminTextHeader());

    }
    @Test
    public void clickOnUserManagementTabAndPerformCorrectActions() throws InterruptedException {
        dashboardPage.setSearchDashboard("Admin");
        driver.findElement(dashboardPage.getMenuItems()).click();
        List<String> navBar = Arrays.asList("User Management", "Job", "Organization", "More");
        for (int i = 0; i < navBar.size(); i++) {
            List<WebElement> menu = driver.findElements(adminPage.getTopBarBodyNavItem());
            if (menu.get(i).getText().equals("User Management")) {
                menu.get(i).click();
                adminPage.clickOnUserManagementDropDown();
//                Add user
                adminPage.setUserName("iyer");
//                 WebDriverWait waitt=new WebDriverWait(driver,Duration.ofSeconds(10));
                Thread.sleep(10);
                adminPage.clickOnUserRole();
                Thread.sleep(1000);
                List<String> userRoleMenu=Arrays.asList("--Select--","Admin","ESS");
                for(int j=0;j<userRoleMenu.size();j++){
                    Thread.sleep(1000);
                    adminPage.clickOnUserRole();
                   List<WebElement> menuItems=adminPage.getUserRole();
                   if(menuItems.get(j).getText().equals("-- Select --")){
                       System.out.println("Select cannot be selected so moving on to next");
                   }
                   else{
                       menuItems.get(j).click();
                       Thread.sleep(1000);
                   }
//
                }
                List<String> statusMenu=Arrays.asList("-- Select --","Enabled","Disabled");
                for(String status:statusMenu){
                    adminPage.clickOnStatus();
                    Thread.sleep(1000);
                    List<WebElement> menuItems=adminPage.getStatusOptions();
                    for(WebElement item:menuItems){
                        if(item.getText().equals(status)){
                            item.click();
                            Thread.sleep(1000);
                            break;
                        }
                    }
                }
                  adminPage.searchAdminClicker();

           }else{
               System.out.println("It's not user management");

          }
            }
        }


    }
