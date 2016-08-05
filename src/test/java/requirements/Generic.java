package requirements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testobject.appium.testng.TestObjectTestNGTestResultWatcher;
import org.testobject.appium.testng.*;
import org.testobject.appium.testng.AppiumDriverProvider;


@Listeners({ TestObjectTestNGTestResultWatcher.class })

public class Generic implements AppiumDriverProvider{


    public AppiumDriver driver;

    @BeforeMethod
    public void LaunchBrowser() throws InterruptedException, IOException {

        System.out.println("Android application under launch");

        // Desired Capabilities settings to launch application in Device
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("testobject_api_key", "63CDBBE0F1BE456FA42139ABA342FE99");
        capabilities.setCapability("testobject_app_id", "1");
        capabilities.setCapability("testobject_device", "LG_Nexus_4_E960_real");

        System.out.println("Launching application");

        driver = new AndroidDriver(new URL("https://app.testobject.com:443/api/appium/wd/hub"), capabilities);
    }

   

    public AppiumDriver getAppiumDriver() {
        return this.driver;
    }

}