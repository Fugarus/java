package project.steam.pageForms;

import org.openqa.selenium.By;
import project.steam.enums.Locale;
import webdriver.BaseForm;
import webdriver.elements.Link;

public class HomePage extends BaseForm implements IGlobarHeader, IMenu {
    private static final String LOC_FORM = "//div[@class='gutter_header']";
    private static final String LOC_LOCALE = "//html[contains(@class,'responsive')]";

    public HomePage() {
        super(By.xpath(LOC_FORM),"HomePage" );
        Locale.setLocale(new Link(By.xpath(LOC_LOCALE)).getAttribute("lang"));
    }
}
