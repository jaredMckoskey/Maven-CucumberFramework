package driver;

import config.Config;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static config.Constants.*;

public class MobileDriverFactory {

    private final HashMap<String, Object> deviceProps = new HashMap<>();

    public MobileDriverFactory(Config config) {
        this.deviceProps.put("platformName", config.mobilePlatform);
        this.deviceProps.put("platformVersion", config.mobileVersion);
    }

    public RemoteWebDriver createDriver() throws MalformedURLException {

        DesiredCapabilities deviceCaps =
                new DesiredCapabilities(deviceProps);

        String platformName = deviceCaps
                .getCapability("platformName")
                .toString()
                .toLowerCase();

        switch (platformName) {
            case ANDROID:
                return getAndroidDriver(deviceCaps);
            case IOS:
                return getIOSDriver(deviceCaps);
            default:
                throw new IllegalArgumentException(String.format("Driver type not implemented: %s", platformName));
        }
    }

    private RemoteWebDriver getAndroidDriver(DesiredCapabilities deviceCaps) throws MalformedURLException {
        deviceCaps = getDefaultMobileCapabilities(deviceCaps);
        deviceCaps.setCapability("platformName", ANDROID);
        deviceCaps.setCapability("app", ANDROID_APP);
        deviceCaps.setCapability("unicodeKeyboard", true);
        deviceCaps.setCapability("resetKeyboard", true);
        deviceCaps.setCapability("deviceName", deviceProps.get("deviceName"));

        return new AndroidDriver<MobileElement>(deviceCaps);
    }

    private RemoteWebDriver getIOSDriver(DesiredCapabilities deviceCaps) throws MalformedURLException {
        deviceCaps = getDefaultMobileCapabilities(deviceCaps);
        deviceCaps.setCapability("platformName", IOS);
        deviceCaps.setCapability("automationName", "XCUITEST");
        deviceCaps.setCapability("deviceName", "iPhone Simulator");
        deviceCaps.setCapability("app", getAppFilePath(IOS_APP));
        deviceCaps.setCapability("bundleId", IOS_APP_BUNDLE_ID);

        return new IOSDriver<MobileElement>(deviceCaps);
    }

    private DesiredCapabilities getDefaultMobileCapabilities(DesiredCapabilities caps) {
        caps.setCapability("newCommandTimeout", 60);
        return caps;
    }

    private File getAppFilePath(String app) {
        String appPath = System.getProperty("user.dir") + "/src/main/resources/apps/" + app;
        File appFile = new File(appPath);
        return appFile;
    }
}
