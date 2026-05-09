package testData;

import PageObjectModel.*;
import driverSetter.driverSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class orangeDahboard {
    private WebDriver driver;
    private OrangeLoginPage loginPage;
    private OrangeDashboardPage dashboardPage;
    private orangeLogin logintest;
    private OrangeTimePage timePage;
    private OrangePerformancePage performancePage;
    private OrangeRecruitmentPage recruitmentPage;
    private OrangeLeavePage leavePage;
    private OrangeBuzzPage buzzPage;
    private driverSet driverSetting;

    @BeforeEach
    public void setDriver(){
        driver=new driverSet().getDriver();

        logintest=new orangeLogin(driver);
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
}
