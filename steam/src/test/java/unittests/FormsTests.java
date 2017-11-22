package unittests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import webdriver.BaseAnnotatedForm;
import webdriver.BaseEntity;
import webdriver.BaseForm;
import webdriver.annotations.UI;
import webdriver.elements.Button;

public class FormsTests extends BaseEntity {

    public class FormTestWithAnnotations extends BaseAnnotatedForm {

        @UI(xpath = "//*", title = "My test button")
        protected Button btn;
        protected By titleLocator; // detect form opening locator
        protected String title; // title of a form
        protected String name; // full name of form that outputted to log, for example, "Form 'Login'"


        public FormTestWithAnnotations() {
            super(By.xpath("//*"), "Test annotation form");
        }

        public String getName() {
            return super.name;
        }

        public String getTitle() {
            return super.title;
        }

        public By getTitleLocator() {
            return super.titleLocator;
        }

    }

    public class FormSimpleTest extends BaseForm {

        protected Button btn = new Button(By.xpath("//button"), "Test button");
        protected By titleLocator;
        protected String title;
        protected String name;

        public FormSimpleTest() {
            super(By.xpath("//*"), "Test simple form");
        }

        public String getName() {
            return super.name;
        }

        public String getTitle() {
            return super.title;
        }

        public By getTitleLocator() {
            return super.titleLocator;
        }
    }

    @Test
    public void TestFormAnnotationInit() {
        FormTestWithAnnotations myTestForm = new FormTestWithAnnotations();
        Assert.assertEquals(myTestForm.getName(), "Form 'Test annotation form'");
        Assert.assertEquals(myTestForm.getTitle(), "Test annotation form");
        Assert.assertEquals(myTestForm.getTitleLocator(), By.xpath("//*"));
    }

    @Test
    public void TestFormSimpleInit() {
        FormSimpleTest myTestForm = new FormSimpleTest();
        Assert.assertEquals(myTestForm.getName(), "Form 'Test simple form'");
        Assert.assertEquals(myTestForm.getTitle(), "Test simple form");
        Assert.assertEquals(myTestForm.getTitleLocator(), By.xpath("//*"));
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
