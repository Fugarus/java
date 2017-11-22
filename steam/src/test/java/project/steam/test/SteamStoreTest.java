package project.steam.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import project.steam.model.Game;
import project.steam.pageForms.*;
import webdriver.BaseTest;

import static framework.support.FileUtils.deleteAllFilesFromFolder;
import static framework.support.FileUtils.isFileDownloaded;
import static project.steam.enums.ContentSection.*;
import static project.steam.enums.GenreGame.*;
import static project.steam.enums.StoreCategory.*;
import static project.steam.pageForms.CheckAgePage.inputAgeAndConfirmSelection;
import static project.steam.pageForms.CheckContentPage.confirmSelectionOnAgeGatePage;

public class SteamStoreTest extends BaseTest {
    private String fileNameSteamInstaller = "SteamSetup.exe";
    private int actualAge = 1970;

    public void runTest(){
        LogStep("Select category and genre");
        HomePage homePage = new HomePage();
        homePage.menu.selectCategory(GAMES);
        homePage.menu.selectGenre(ACTION);

        LogStep("Select content section and search suitable games");
        ContentPage contentPage = new ContentPage();
        contentPage.selectContentSection(SPECIALS);
        Game maxSpecialGame = contentPage.discountsRowsGames.selectAndGetMaxSpecialGame();

        LogStep("Check info by selected games");
        inputAgeAndConfirmSelection(actualAge);
        confirmSelectionOnAgeGatePage();

        GamePage gamePage = new GamePage();
        Game selectedGameFromGamePage = gamePage.getSelectedGame();

        softAssertEquals(selectedGameFromGamePage.getDiscountPercentage(), maxSpecialGame.getDiscountPercentage(),
                "Selected special equally special gameMaxSpecial");
        softAssertEquals(selectedGameFromGamePage.getFinalPrice(), maxSpecialGame.getFinalPrice(),
                "Selected final price equally final price gameMaxSpecial");
        softAssertEquals(selectedGameFromGamePage.getName(), maxSpecialGame.getName(),
                "Selected name equally name gameMaxSpecial");

        LogStep("Download steamInstaller");
        gamePage.globalHeader.clickDownload();
        new AboutPage().clickInstallLink();
        assertTrue(isFileDownloaded(fileNameSteamInstaller),  String.format("File %s wasn't downloaded", fileNameSteamInstaller));
    }

    @BeforeTest
    public void beforeTest(){
        deleteAllFilesFromFolder();
    }

    @AfterTest
    public void afterTest(){
        checkSortErrors();
    }

    @Override
    public boolean shouldAnalys() {
        return false;
    }

    @Override
    public void invokeAnalys(Throwable exc, String bodyText) throws Throwable {

    }
}
