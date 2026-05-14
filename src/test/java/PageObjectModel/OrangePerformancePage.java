package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangePerformancePage {
    private WebDriver driver;
    private By performancePageText= By.xpath("//h6[normalize-space()='Performance']");
    public OrangePerformancePage(WebDriver driver){
        this.driver=driver;
    }
    public String getPerformancePageConfirmationText(){
        return driver.findElement(performancePageText).getText();
    }
}
