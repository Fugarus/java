package project.steam.pageForms;

import org.openqa.selenium.By;
import project.steam.enums.OldElement;
import webdriver.elements.Button;
import webdriver.elements.Label;

public class CheckContentPage implements IGlobarHeader {
    private static Label lblAgeGate = new Label(By.xpath("//div[@class='agegate_text_container']"), "Age Gate Page");
    private static String locBtnInAgePage = "//div[contains(@class, 'agegate_text_container')]//span[contains(text(), '%s')]";

    private static boolean isPresentAgeGatePage(){
        return lblAgeGate.isPresent();
    }

    public static void confirmSelectionOnAgeGatePage(){
        if (isPresentAgeGatePage()) {
            new Button(By.xpath(String.format(locBtnInAgePage, OldElement.VIEW_PAGE.getName())), OldElement.VIEW_PAGE.getName()).click();
        }
    }

}
