package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeRecruitmentPage {
    private WebDriver driver;
    private By recruitmentPageText= By.xpath("//h6[normalize-space()='Recruitment']");
    public OrangeRecruitmentPage(WebDriver driver){
        this.driver=driver;
    }
    public String getRecruitmentPageText(){
        return driver.findElement(recruitmentPageText).getText();
    }
}
