package driverSetter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class driverSet {
    private WebDriver driver;
    ChromeOptions options = new ChromeOptions();



    public WebDriver getDriver(){
        driver=new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        options.addArguments("--lang=en-US");
        options.addArguments("--accept-lang=en-US,en;q=0.9");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;


    }
}
