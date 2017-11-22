package framework.support;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Browser;
import webdriver.PropertiesResourceManager;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileUtils {
    private static PropertiesResourceManager projectProperties = new PropertiesResourceManager("project.properties");
    public static String dirDownloadedFiles = System.getProperty("user.dir")+projectProperties.getProperty("dirSaveDonwloadedFiles");

    public static boolean isFileDownloaded(final String fileName) {
        ExpectedCondition<Boolean> fileLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver input) {
                File dir = new File(dirDownloadedFiles);
                File[] dirContents = dir.listFiles();
                for (int i = 0; i < dirContents.length; i++) {
                    if (dirContents[i].getName().equals(fileName) && dirContents[i].length() > 0)
                        return true;
                }
                return false;
            }
        };

        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20);
        wait.pollingEvery(1, TimeUnit.SECONDS).until(fileLoad);
        return true;
    }

    public static void deleteAllFilesFromFolder(){
        System.out.println(dirDownloadedFiles);
        try {
            for (File myFile : new File(dirDownloadedFiles).listFiles()) {
                if (myFile == null)
                    break;
                if (myFile.isFile()) myFile.delete();
            }
        }catch (Exception e){

        }
    }
}
