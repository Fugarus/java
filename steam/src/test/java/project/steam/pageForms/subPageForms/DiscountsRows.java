package project.steam.pageForms.subPageForms;

import org.openqa.selenium.By;
import project.steam.enums.ContentSection;
import project.steam.model.Game;
import webdriver.elements.Button;
import webdriver.elements.Label;

import java.util.ArrayList;
import java.util.List;

public class DiscountsRows {
    private String locTabItem = "//div[@id='%s']//*[contains(@class,'%s')]";
    private String locActiveTabBlock = "//div[@id='%s']//*[contains(@style, 'opacity: 1;')]";

    private final String DISCOUNT_PTC = "discount_pct";
    private final String TAB_ITEM_NAME = "tab_item_name";
    private final String DISCOUNT_FINAL_PRICE = "discount_final_price";

    private List<String> discountsPercentage=new ArrayList<String>();
    private List<String> itemsName=new ArrayList<String>();
    private List<String> finalsPrice=new ArrayList<String>();
    private List<Game>discountGames=new ArrayList<Game>();

    public DiscountsRows(){
        String contentSection = ContentSection.NEW_AND_TRENDING.getId();
        this.locTabItem = String.format(locTabItem, contentSection, "%s");
        this.locActiveTabBlock = String.format(locActiveTabBlock, contentSection);
    }

    public DiscountsRows(String contentSection){
        this.locTabItem = String.format(locTabItem, contentSection, "%s");
        this.locActiveTabBlock = String.format(locActiveTabBlock, contentSection);
    }

    private void initDiscountGames() {
        if (new Label(By.xpath(locActiveTabBlock)).isPresent()) {
            itemsName=new Label(By.xpath(String.format(locTabItem, TAB_ITEM_NAME))).getTextsFromElements();
            finalsPrice=new Label(By.xpath(String.format(locTabItem, DISCOUNT_FINAL_PRICE))).getTextsFromElements();
            discountsPercentage=new Label(By.xpath(String.format(locTabItem, DISCOUNT_PTC))).getTextsFromElements();
        }
    }

    private void initGames(){
        initDiscountGames();
        for(int i=0;i<discountsPercentage.size();i++){
            int discount = Integer.parseInt((discountsPercentage.get(i)).replace("%",""));
            double price = Double.parseDouble((finalsPrice.get(i)).replace("$",""));
            String name = itemsName.get(i).trim();
            discountGames.add(new Game(name,discount,price));
        }
    }

    private int getPositionMaxSpecialGame(){
        int indexGamesMaxSpecial = 0;
        Game maxSpecialGame = discountGames.get(indexGamesMaxSpecial);
        for(int i=1;i<discountGames.size();i++){
            if(maxSpecialGame.getDiscountPercentage() > discountGames.get(i).getDiscountPercentage()){
                indexGamesMaxSpecial = i;
                maxSpecialGame = discountGames.get(i);
            }
        }
        return indexGamesMaxSpecial;

    }

    public Game selectAndGetMaxSpecialGame(){
        initGames();
        int position = getPositionMaxSpecialGame();
        String loc = String.format(locTabItem, TAB_ITEM_NAME);
        new Button(By.xpath(String.format("(%s)[%d]", loc, position+1))).click();
        return discountGames.get(getPositionMaxSpecialGame());
    }

}
