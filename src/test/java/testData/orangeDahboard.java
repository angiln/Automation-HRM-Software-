package testData;

import PageObjectModel.*;
import driverSetter.driverSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class orangeDahboard {
    private WebDriver driver;
    private OrangeLoginPage loginPage;
    private OrangeDashboardPage dashboardPage;

    private OrangeTimePage timePage;
    private OrangePerformancePage performancePage;
    private OrangeRecruitmentPage recruitmentPage;
    private OrangeLeavePage leavePage;
    private OrangeBuzzPage buzzPage;
    private driverSet driverSetting;

    @BeforeEach
    public void setDriver(){
        driver=new driverSet().getDriver();


        dashboardPage =new OrangeDashboardPage(driver);
        timePage=new OrangeTimePage(driver);
        loginPage=new OrangeLoginPage(driver);
        performancePage=new OrangePerformancePage(driver);
        recruitmentPage=new OrangeRecruitmentPage(driver);
        leavePage = new OrangeLeavePage(driver);
        buzzPage=new OrangeBuzzPage(driver);
        loginPage.loggerApp("Admin","admin123");

    }
    @AfterEach
    public void killDriver(){
     driver.quit();
    }
    @Test
    public void redirectionToAttendancePage(){
        dashboardPage.clickTimerIcon().click();
        Assertions.assertEquals("Attendance",timePage.getAttendanceText());
    }
    @Test
    public void redirectionToPerformanceManagePage(){
        dashboardPage.clickMyActionPage1stIcon();
        Assertions.assertEquals("Performance",performancePage.getPerformancePageConfirmationText());
    }
    @Test
    public void redirectionToRecruitmentPage(){
        dashboardPage.clickMyActionTab2ndIcon();
        Assertions.assertEquals("Recruitment",recruitmentPage.getRecruitmentPageText());
    }
    @Test
    public void travelThroughQuickLaunchMenu(){
        List<String> expectedTitles= Arrays.asList(
                "Assign Leave",
                "Leave List",
                "Select Employee",
                "Apply Leave",
                "My Leave List","My Timesheet");
        for(int i=0; i<expectedTitles.size();i++) {
            List<WebElement> menu = driver.findElements(dashboardPage.getQuickLaunchMenu());
            menu.get(i).click();

            String actualTitle = null;
            switch (expectedTitles.get(i)) {
                case "Select Employee":
                    actualTitle = timePage.getMainTitle();
                    break;
                case "My Timesheet":
                    actualTitle = timePage.getMainTitle();
                    break;
                case "Assign Leave":
                    actualTitle = leavePage.getAssignLeaveTabText();
                    break;
                case "Leave List":
                    actualTitle = leavePage.getLeaveListTabText();
                    break;
                case "Apply Leave":
                    actualTitle = leavePage.getApplyLeaveTabText();
                    break;
                case "My Leave List":
                    actualTitle = leavePage.getMyLeaveListTabText();
                    break;
                default:
                    System.out.println("Out of bound ");
            }

            Assertions.assertEquals(expectedTitles.get(i), actualTitle);
            driver.navigate().back();

        }

    }
    @Test
    public void scrollAndViewNewsfeedPost() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
//        Actions actions = new Actions(driver);
        WebElement newsfeed=driver.findElement(dashboardPage.getBuzzLatestPost());
//        actions.moveToElement(newsfeed).perform();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});",newsfeed);
        dashboardPage.clickOnBuzzPostUser();
        Assertions.assertEquals("Buzz",buzzPage.getBuzzNewsfeedHeadingText());

    }
    @Test
    public void clickOnEmployeesOnLeaveTodaySetting(){
             dashboardPage.clickOnEmployeesOnLeaveSetting();
             Assertions.assertEquals("",dashboardPage.getEmployeesOnLeavePromptText());
             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
             dashboardPage.employeesOnLeavePromptCloser();

    }
    @Test
    public void hoverEmployeeDistribution(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          List<WebElement> element1=driver.findElements(dashboardPage.getFirstPieChartElements());
          wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          for(int i=0;i< element1.size();i++){
              element1.get(i).click();


              System.out.println(element1.get(i).getText());
             String style= element1.get(i).getAttribute("text-decoration");
              System.out.println(style);
             Assertions.assertEquals("line-through",style);
          }
    }
    @Test
    public void upgradeButtonWorks() throws InterruptedException {
        dashboardPage.clickOnUpgradeButton();
        Thread.sleep(5000);
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
//        driver.switchTo().window(driver.getWindowHandles().iterator().next());euta matra
//        iterator vayo vane parent tab ma nai janxa so switch garnai lai arraylist mai rakhda better.
        Assertions.assertEquals("https://orangehrm.com/open-source/upgrade-to-advanced",driver.getCurrentUrl());
    }
    @Test
    public void userIconWorks(){
        dashboardPage.clickOnUserIcon();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String styleUserDropdown=driver.findElement(dashboardPage.getUserIcon()).getAttribute("class");
        Assertions.assertEquals("--active oxd-userdropdown",styleUserDropdown);
    }
    @Test
    public void helpButtonWorks(){
        dashboardPage.clickOnHelpIcon();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assertions.assertEquals("https://starterhelp.orangehrm.com/hc/en-us",driver.getCurrentUrl());
    }
    @Test
    public void clickOnFooterOHRMlink(){
        JavascriptExecutor jsexecute=(JavascriptExecutor)driver;

        jsexecute.executeScript("window.scrollBy(0,800)");
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        dashboardPage.clickOnFooterOHRMlink();
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assertions.assertEquals("https://orangehrm.com/",driver.getCurrentUrl());
    }
    @Test
    public void clickOnSidebarArrow(){
        dashboardPage.sideBarArrowClicker();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        Assertions.assertEquals("oxd-icon bi-chevron-right",driver.findElement(dashboardPage.getSideBarArrowRight()).getAttribute("class"));
    }
    @Test
    public void clickOnOrangeHrmLogo(){
        dashboardPage.clickOrangehrmLogo();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        Assertions.assertEquals("https://orangehrm.com/",driver.getCurrentUrl());

    }
    @Test
    public void searchThrough() {
        List <String> searchItem=Arrays.asList("Admin","PIM","Leave","Time","Recruitment","My Info","Performance",
                "Dashboard","Directory","Maintenance","Claim","Buzz");
//        System.out.println("SearchItem size is "+searchItem.size());
//        for(int i=0;i<searchItem.size();i++){
//            System.out.println("The "+i+" item is "+searchItem.get(i));
//        }
        for(int i=0;i<searchItem.size();i++){
        dashboardPage.setSearchDashboard(searchItem.get(i));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        Assertions.assertEquals(searchItem.get(i),dashboardPage.getSearchedItem(searchItem.get(i)));
            dashboardPage.searchBarClear();
        }

    }
    @Test
    public void goToAllMenuItems(){
     List<String> elementa=Arrays.asList("Admin","PIM","Leave","Time","Recruitment","My Info","Performance",
             "Dashboard","Directory","Maintenance","Claim","Buzz");
     for(int i =0;i<elementa.size();i++){
         List <WebElement> menus=driver.findElements(dashboardPage.getMenuItems());
         if(menus.get(i).getText().equals("Maintenance")){
            driver.findElement(By.xpath("//button[contains(@class,'oxd-button--ghost')]")).click();
         }else {
             menus.get(i).click();

         }
     }
    }
}
