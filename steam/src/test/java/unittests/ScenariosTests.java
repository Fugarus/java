package unittests;

import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseEntity;
import webdriver.BaseTest;
import webdriver.BaseTestParam;

public class ScenariosTests extends BaseEntity {

    private static String initMarker = null;


    public class SimpleScenarioTest extends BaseTest {

        @Override
        public void runTest() {
            initMarker = "simple";
        }

        @Override
        public void invokeAnalys(Throwable exc, String bodyText) throws Throwable {
            // not necessary yet
        }

        @Override
        public boolean shouldAnalys() {
            return false;
        }

    }

    public class ParametersScenarioTest extends BaseTestParam {

        @Test
        @Parameters()
        public void readParams() throws Throwable {
            xTest();
        }


        @Override
        public void runTest() {
            initMarker = "parameters";
        }

        @Override
        public void invokeAnalys(Throwable exc, String bodyText) throws Throwable {
            // not necessary yet
        }

        @Override
        public boolean shouldAnalys() {
            return false;
        }

    }


    @Test
    public void testSimpleScenarioInit() {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{SimpleScenarioTest.class});
        testng.addListener(tla);
        testng.run();
        Assert.assertEquals(initMarker, "simple");
    }

    @Test
    public void testParametersScenarioInit() {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{ParametersScenarioTest.class});
        testng.addListener(tla);
        testng.run();
        Assert.assertEquals(initMarker, "parameters");
    }

    @AfterClass
    public void after() {
        //	nothing to do here
    }

    @Override
    protected String formatLogMsg(String message) {
        return null;
    }


}

	

