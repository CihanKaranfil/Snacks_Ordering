package snacks_ordering;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class GirisModulü {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "app-release.apk";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("udid", "emulator-5554");
        //capabilities.setCapability("app", appUrl);
        capabilities.setCapability("appPackage", "com.example.snacks_ordering_app");
        capabilities.setCapability("appActivity", "com.example.snacks_ordering_app.MainActivity");

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, capabilities);
        Thread.sleep(3000);

        WebElement createAccount = driver.findElement(AppiumBy.accessibilityId("Create Account"));
        createAccount.click();

    }

}
