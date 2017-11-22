package project.steam.enums;

import webdriver.PropertiesResourceManager;

public abstract class Locale {
    private static final PropertiesResourceManager LOC_RUS = new PropertiesResourceManager("locale_rus_steam.properties");
    private static final PropertiesResourceManager LOC_EN = new PropertiesResourceManager("locale_en_steam.properties");
    private static PropertiesResourceManager selectedLocale = LOC_EN;

    private final static String RUSSIAN = "ru";
    private final static String ENGLISH = "en";

    public static PropertiesResourceManager getSelectedLocale() {
        return selectedLocale;
    }

    public static void setLocale(String locale) {
        switch (locale){
            case ENGLISH: selectedLocale = LOC_EN; break;
            case RUSSIAN: selectedLocale = LOC_RUS; break;
            default: break;
        }
    }
}
