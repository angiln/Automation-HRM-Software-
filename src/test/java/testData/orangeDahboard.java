package testData;

import PageObjectModel.OrangeDashboardPage;
import PageObjectModel.OrangeLoginPage;
import PageObjectModel.OrangeTimePage;
import driverSetter.driverSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class orangeDahboard {
    private WebDriver driver;
    private OrangeLoginPage loginPage;
    private OrangeDashboardPage dashboardPage;
    private orangeLogin logintest;
    private OrangeTimePage timePage;
    private driverSet driverSetting;

    @BeforeEach
    public void setDriver(){
        driver=new driverSet().getDriver();

        logintest=new orangeLogin(driver);
        dashboardPage =new OrangeDashboardPage(driver);
        timePage=new OrangeTimePage(driver);
        loginPage=new OrangeLoginPage(driver);
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
}
