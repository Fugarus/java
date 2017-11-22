package project.steam.pageForms;

import org.openqa.selenium.By;
import project.steam.enums.OldElement;
import project.steam.model.Game;
import webdriver.BaseForm;
import webdriver.elements.Label;

public class GamePage extends BaseForm implements IGlobarHeader, IMenu {
    private static final String LOC_FORM = "//div[@class='page_content_ctn']";
    private Label lblGameName =
            new Label(By.xpath("//div[@class='game_area_purchase_game']//h1"));
    private Label lblDiscountPercentage =
            new Label(By.xpath("//div[contains(@class, 'game_purchase_discount')]//div[@class='discount_pct']"));
    private  Label lblFinalPrice =
            new Label(By.xpath("//div[contains(@class, 'game_purchase_discount')]//div[@class='discount_final_price']"));

    public GamePage(){
        super(By.xpath(LOC_FORM),"GamePage");
    }

    public Game getSelectedGame(){
        String name= lblGameName.getText().replace(OldElement.BUY.getName(),"").trim();
        int discount=Integer.parseInt((lblDiscountPercentage.getText()).replace("%",""));
        double finalPrc=Double.parseDouble((lblFinalPrice.getText().replace("$","").replace(OldElement.AMOUNT.getName(),"")));
        return new Game(name, discount, finalPrc);
    }
}
