package unittests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import webdriver.BaseEntity;
import webdriver.Browser;

public class BrowserTests extends BaseEntity {

    @Test
    public void testButtonInit() {
        Assert.assertNotNull(getBrowser(), "browser should be initialized");
        Assert.assertTrue(Browser.getDriver() != null, "browser should be initialized");
    }

    @AfterClass
    public void after() {
        // do nothing
    }

    @Override
    protected String formatLogMsg(String message) {
        return null;
    }

}

