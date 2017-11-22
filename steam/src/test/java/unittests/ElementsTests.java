package unittests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import webdriver.BaseEntity;
import webdriver.elements.Button;
import webdriver.elements.CheckBox;
import webdriver.elements.ComboBox;
import webdriver.elements.Label;
import webdriver.elements.Link;
import webdriver.elements.RadioButton;
import webdriver.elements.TextBox;


public class ElementsTests extends BaseEntity {

	@Test
	public void testTextBoxInit(){
		TextBox txb1 = new TextBox(By.id("test textbox"), "Test texbox");
		Assert.assertEquals(txb1.getLocator(),By.id("test textbox"));
		Assert.assertEquals(txb1.getName(),"Test texbox");
    }

	@Test
	public void testComboBoxInit(){
		ComboBox cmb1 = new ComboBox(By.id("test combo"), "Test combobox");
		Assert.assertEquals(cmb1.getLocator(),By.id("test combo"));
		Assert.assertEquals(cmb1.getName(),"Test combobox");
    }
	
	@Test
	public void testCheckBoxInit(){
		CheckBox chk1 = new CheckBox(By.id("test checkbox"), "Test checkbox");
		Assert.assertEquals(chk1.getLocator(),By.id("test checkbox"));
		Assert.assertEquals(chk1.getName(),"Test checkbox");
    }
	
	@Test
	public void testLinkInit(){
		Link lnk1 = new Link(By.id("test link"), "Test link");
		Assert.assertEquals(lnk1.getLocator(),By.id("test link"));
		Assert.assertEquals(lnk1.getName(),"Test link");
    }
	
	@Test
	public void testLabelInit(){
		Label lbl1 = new Label(By.id("test label"), "Test label");
		Assert.assertEquals(lbl1.getLocator(),By.id("test label"));
		Assert.assertEquals(lbl1.getName(),"Test label");
    }
	
	@Test
	public void testButtonInit(){
		Button btn1 = new Button(By.id("test button"), "Test button");
		Assert.assertEquals(btn1.getLocator(),By.id("test button"));
		Assert.assertEquals(btn1.getName(),"Test button");
    }
	
	@Test
	public void testRadioButtonInit(){
		RadioButton rdnbtn1 = new RadioButton(By.id("test radiobutton"), "Test radiobutton");
		Assert.assertEquals(rdnbtn1.getLocator(),By.id("test radiobutton"));
		Assert.assertEquals(rdnbtn1.getName(),"Test radiobutton");
    }

	@Test
	public void testHiddenInit(){
		RadioButton rdnbtn1 = new RadioButton(By.id("test hidden"), "Test hidden");
		Assert.assertEquals(rdnbtn1.getLocator(),By.id("test hidden"));
		Assert.assertEquals(rdnbtn1.getName(),"Test hidden");
    }
	
	@AfterClass
	public void after(){
		// do nothing
	}

	@Override
	protected String formatLogMsg(String message) {
		return null;
	}

}
