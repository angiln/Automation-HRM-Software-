package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeBuzzPage {
    private WebDriver driver;
    private final By buzzNewsfeedText= By.xpath("//h6[text()='Buzz']");
    public OrangeBuzzPage(WebDriver driver){
        this.driver=driver;
    }
    public String getBuzzNewsfeedHeadingText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return driver.findElement(buzzNewsfeedText).getText();
    }
}
