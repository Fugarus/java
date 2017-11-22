package project.steam.pageForms.subPageForms;

import org.openqa.selenium.By;
import webdriver.elements.Button;

public class GlobalHeader {
    private Button btnInstall=
            new Button(By.xpath("//a[@class='header_installsteam_btn_content']")," buttonInstall");

    public void clickDownload(){
        btnInstall.click();
    }
}
