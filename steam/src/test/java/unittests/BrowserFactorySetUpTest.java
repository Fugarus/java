package unittests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import webdriver.BaseEntity;
import webdriver.Browser;
import webdriver.BrowserFactory;
import webdriver.ProxyServ;

import java.lang.reflect.Field;

/**
 * Created by p.ordenko on 26.03.2015, 11:14.
 */
public class BrowserFactorySetUpTest extends BaseEntity {

    private RemoteWebDriver driver;

    /**
     * Firefox tests
     */
    @Test(priority = 1)
    public void testFirefoxInit() {
        Browser.getDriver().quit();
        driver = BrowserFactory.setUp(Browser.Browsers.FIREFOX);
        Assert.assertNotNull(driver, "Firefox driver is not initialized");
    }

    @Test(priority = 2)
    public void testFirefoxInitWithDetectErrors() {
        boolean isPropertySet = setBrowserProperty("detectJsErrors", "true");
        Assert.assertTrue(isPropertySet, "Browser property 'detectJsErrors' was not set");
        driver = BrowserFactory.setUp(Browser.Browsers.FIREFOX);
        Assert.assertNotNull(driver, "Chrome driver is not initialized");
    }

    @Test(priority = 3)
    public void testFirefoxInitWithoutDetectErrors() {
        boolean isPropertySet = setBrowserProperty("detectJsErrors", "false");
        Assert.assertTrue(isPropertySet, "Browser property 'detectJsErrors' was not set");
        driver = BrowserFactory.setUp(Browser.Browsers.FIREFOX);
        Assert.assertNotNull(driver, "Chrome driver is not initialized");
    }

    /**
     * Chrome tests
     */
    @Test(priority = 4)
    public void testChromeInit() {
        driver = BrowserFactory.setUp(Browser.Browsers.CHROME);
        Assert.assertNotNull(driver, "Chrome driver is not initialized");
    }

    @Test(priority = 5)
    public void testChromeInitWithDetectErrors() {
        boolean isPropertySet = setBrowserProperty("detectJsErrors", "true");
        Assert.assertTrue(isPropertySet, "Browser property 'detectJsErrors' was not set");
        driver = BrowserFactory.setUp(Browser.Browsers.CHROME);
        Assert.assertNotNull(driver, "Chrome driver is not initialized");
    }

    @Test(priority = 6)
    public void testChromeInitWithTrafficAnalysis() {
        boolean isPropertySet = setBrowserProperty("analyzeTraffic", "true");
        Assert.assertTrue(isPropertySet, "Browser property 'analyzeTraffic' was not set");
        driver = BrowserFactory.setUp(Browser.Browsers.CHROME);
        Assert.assertNotNull(driver, "Chrome driver is not initialized");
    }

    @Test(priority = 7)
    public void testChromeInitWithoutDetectErrors() {
        boolean isPropertySet = setBrowserProperty("detectJsErrors", "false");
        Assert.assertTrue(isPropertySet, "Browser property 'detectJsErrors' was not set");
        driver = BrowserFactory.setUp(Browser.Browsers.CHROME);
        Assert.assertNotNull(driver, "Chrome driver is not initialized");
    }

    @Test(priority = 8)
    public void testChromeInitWithoutTrafficAnalysis() {
        boolean isPropertySet = setBrowserProperty("analyzeTraffic", "false");
        Assert.assertTrue(isPropertySet, "Browser property 'analyzeTraffic' was not set");
        driver = BrowserFactory.setUp(Browser.Browsers.CHROME);
        Assert.assertNotNull(driver, "Chrome driver is not initialized");
    }

    /**
     * Internet Explorer tests
     */
    @Test(priority = 9)
    public void testIEInit() {
        driver = BrowserFactory.setUp(Browser.Browsers.IEXPLORE);
        Assert.assertNotNull(driver, "Chrome driver is not initialized");
    }

    @Test(priority = 10)
    public void testIEInitWithLocalRun() {
        boolean isPropertySet = setBrowserProperty("ieLocalRun", "true");
        Assert.assertTrue(isPropertySet, "Browser property 'ieLocalRun' was not set");
        driver = BrowserFactory.setUp(Browser.Browsers.IEXPLORE);
        Assert.assertNotNull(driver, "Chrome driver is not initialized");
    }

    @Test(priority = 11)
    public void testIEInitWithLocalRunAndTrafficAnalysis() {
        boolean isPropertySet = setBrowserProperty("ieLocalRun", "true");
        Assert.assertTrue(isPropertySet, "Browser property 'ieLocalRun' was not set");
        isPropertySet = setBrowserProperty("analyzeTraffic", "true");
        Assert.assertTrue(isPropertySet, "Browser property 'analyzeTraffic' was not set");
        driver = BrowserFactory.setUp(Browser.Browsers.IEXPLORE);
        Assert.assertNotNull(driver, "Chrome driver is not initialized");
    }

    // unstable work at VM
    @Test(priority = 12, enabled = false)
    public void testIEInitWithoutLocalRun() {
        boolean isPropertySet = setBrowserProperty("ieLocalRun", "false");
        Assert.assertTrue(isPropertySet, "Browser property 'ieLocalRun' was not set");
        driver = BrowserFactory.setUp(Browser.Browsers.IEXPLORE);
        Assert.assertNotNull(driver, "Chrome driver is not initialized");
    }

    // Return default property values to Browser
    @AfterMethod
    public void killBrowser() {
        driver.quit();
        setBrowserProperty("ieLocalRun", "true");
        setBrowserProperty("analyzeTraffic", "false");
        setBrowserProperty("detectJsErrors", "false");
        setBrowserProperty("currentBrowser", Browser.Browsers.FIREFOX);
        setBrowserProperty("instance", null);
        assertEquals("localrun wasn't reset", Browser.getIeLocalRun(), true);
        assertEquals("analyzeTraffic wasn't reset", Browser.getAnalyzeTraffic(), false);
        assertEquals("detectJsError wasn't reset", Browser.getDetectJsErrors(), false);
        assertEquals("currentBrowser wasn't reset", Browser.currentBrowser, Browser.Browsers.FIREFOX);
        info("Browser was reset to default state");
    }

    @AfterClass
    @Override
    public void after() {
        ProxyServ.stopProxyServer();
    }

    private boolean setBrowserProperty(String propertyName, Object propertyValue) {
        try {
            Field field = Browser.class.getDeclaredField(propertyName);
            boolean accessibility = field.isAccessible();
            field.setAccessible(true);
            field.set(null, propertyValue);
            field.setAccessible(accessibility);
            return true;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            logger.debug(this, e);
            return false;
        }
    }

    @Override
    protected String formatLogMsg(String message) {
        return null;
    }
}
