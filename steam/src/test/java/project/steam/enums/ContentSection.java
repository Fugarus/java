package project.steam.enums;

public enum ContentSection {
    SPECIALS("tab_Discounts_content", "specials"),
    NEW_AND_TRENDING("tab_PopularNewReleases_content", "trending");

    private String id;
    private String name;

    ContentSection(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return Locale.getSelectedLocale().getProperty(this.name);
    }
}
