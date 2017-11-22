package project.steam.pageForms;

import org.openqa.selenium.By;
import webdriver.elements.Button;
import webdriver.elements.ComboBox;
import webdriver.elements.Label;

public class CheckAgePage implements IGlobarHeader {
    private static String locAgeCheck = "//select[@id='%s']";
    private static Button btnEnter = new Button(By.xpath("//div[@id='agegate_box']//a[contains(@class, 'btnv6_blue_hoverfade')]"), "Enter");
    private static Label lblAgeForm = new Label(By.xpath("//form[@id='agecheck_form']"), "Check Age Page");
    private static final String YEAR_ID = "ageYear";

    private static boolean isPresentCheckAgePage(){
        return lblAgeForm.isPresent();
    }

    public static void inputAgeAndConfirmSelection(int age){
        if(isPresentCheckAgePage()){
            new ComboBox(By.xpath(String.format(locAgeCheck, YEAR_ID)),String.format("ageValue: %d", age)).selectByText(String.valueOf(age));
            btnEnter.click();
        }
    }
}
