package project.steam.pageForms.subPageForms;

import org.openqa.selenium.By;
import project.steam.enums.GenreGame;
import project.steam.enums.StoreCategory;
import webdriver.elements.Button;

public class Menu {
    private String locGenreGames = "//div[@id='genre_flyout']//a[contains(text(),'%s')]";
    private String locStoreCategories = "//div[@id='%s']/span/span";

    public void selectCategory(StoreCategory category){
        new Button(By.xpath(String.format(locStoreCategories, category.getId())), category.getId()).clickViaJS();
    }

    public void selectGenre(GenreGame genre){
        new Button(By.xpath(String.format(locGenreGames, genre.getName())), genre.getName()).waitAndClick();
    }
}
