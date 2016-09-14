package test;

import io.appium.java_client.AppiumDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by suryat on 13/09/2016.
 */
public class MainTest {


    public static AppiumDriver wd;
    static boolean ci = false; // it could be set to true if CI is true

    @BeforeClass
    public static void start() {


        try {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium-version", "1.4");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "5.1");
            capabilities.setCapability("deviceName", "surya");
            File app = new File("C:\\Users\\suryat\\Desktop\\BookSearch_1.0.apk");
            capabilities.setCapability("appPackage", "com.codepath.android.booksearch");
            capabilities.setCapability("appActivity", "com.codepath.android.booksearch.activites.BookListActivity");
            AppiumDriver driver;
            wd = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities) {
                public WebElement scrollTo(java.lang.String text) {
                    return null;
                }

                public WebElement scrollToExact(java.lang.String text) {
                    return null;
                }


            };



        } catch (Exception e) {
            e.printStackTrace();
        }





    }




    @Test

    public void RunTest(){
try{
    wd.findElement(By.id(locators.SearchTest)).click();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    //can also use explicit wait
    wd.findElement(By.linkText(locators.BookNameSearch)).click();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}catch (NullPointerException e){
e.printStackTrace();
}

    }

}

