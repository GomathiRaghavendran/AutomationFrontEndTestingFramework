package base;

import globalResource.GLOBALSTATIC;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Base {
    public void launchBrowser() throws IOException {
        openSpecificBrowser("chrome");
        GLOBALSTATIC.driver.manage().window().maximize();
        GLOBALSTATIC.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    public void openSpecificBrowser(String browser){
        if(browser.equals("Chrome")|| browser.equals("chrome") ) {
            GLOBALSTATIC.driver = new ChromeDriver();
        }
        if(browser.equals("Firefox")|| browser.equals("firefox") || browser.equals("FF") )
        {
            GLOBALSTATIC.driver = new FirefoxDriver();
        }
        if (browser.equals("Edge")) {
            GLOBALSTATIC.driver = new EdgeDriver();
        }
    }
}
