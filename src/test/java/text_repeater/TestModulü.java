package text_repeater;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestModulü  extends ReusableMethods {

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "app-release.apk";

        serverBaslat();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("udid", "emulator-5554");
        //capabilities.setCapability("app", appUrl);
        capabilities.setCapability("appPackage", "com.example.text_repeater");
        capabilities.setCapability("appActivity", "com.example.text_repeater.MainActivity");

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, capabilities);
        Thread.sleep(3000);

       WebElement getStarted = driver.findElement(AppiumBy.accessibilityId("Get Started"));
        getStarted.click();
        Thread.sleep(1000);

        WebElement textRepearter = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Text Repeater\n" +
                "Repeat any text multiple times\"]"));
        textRepearter.click();

        WebElement text = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        text.click();
        text.sendKeys("Hello Mehmet");

        WebElement repeatCount = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
        repeatCount.click();
        repeatCount.sendKeys("10");

        WebElement repeatButton = driver.findElement(AppiumBy.accessibilityId("Repeat"));
        repeatButton.click();

        WebElement copyButton = driver.findElement(AppiumBy.accessibilityId("Copy"));
        copyButton.click();
       // DesiredCapabilities capabilities2 = new DesiredCapabilities();
       // capabilities.setCapability("platformName", "android");
       // capabilities.setCapability("automationName", "uiautomator2");
       // capabilities.setCapability("udid", "emulator-5554");
       // //capabilities.setCapability("app", appUrl);
       // capabilities.setCapability("appPackage", "com.example.text_repeater");
       // capabilities.setCapability("appActivity", "com.example.text_repeater.MainActivity");
//
       // URL url2 = new URL("http://0.0.0.0:4723");
       // AndroidDriver driver2 = new AndroidDriver(url, capabilities);
       // Thread.sleep(3000);



    }

}
