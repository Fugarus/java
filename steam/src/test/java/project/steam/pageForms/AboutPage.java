package project.steam.pageForms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

public class AboutPage extends BaseForm implements IGlobarHeader {
    private Button buttonInstallLink=
            new Button(By.xpath("//div[@id='about_greeting_ctn']//a[@id='about_install_steam_link']"),"Install Link");

    private static final String LOC_FORM= "//div[@id='about_header_area']";

    public AboutPage() {
        super(By.xpath(LOC_FORM),"HomePage" );
    }

    public void clickInstallLink(){
        buttonInstallLink.click();
    }
}
