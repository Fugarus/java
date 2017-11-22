package project.steam.pageForms;

import org.openqa.selenium.By;
import project.steam.enums.ContentSection;
import project.steam.pageForms.subPageForms.DiscountsRows;
import webdriver.BaseForm;
import webdriver.elements.Button;


public class ContentPage  extends BaseForm implements IGlobarHeader, IMenu {
    private static final String LOC_FORM= "//h2[contains(@class, 'tag_pageheader')]";
    private String locTabContent = "//div[@class='tab_content'][contains(text(), '%s')]";

    public DiscountsRows discountsRowsGames = new DiscountsRows();

    public ContentPage() {
        super(By.xpath(LOC_FORM),"ContentPage" );
    }

    public void selectContentSection(ContentSection contentSection){
        discountsRowsGames = new DiscountsRows(contentSection.getId());
        new Button(By.xpath(String.format(locTabContent, contentSection.getName())), contentSection.getName()).click();
    }
}
