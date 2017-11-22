package project.steam.enums;

public enum OldElement {
    AMOUNT("amount"),
    BUY("buy"),
    VIEW_PAGE("openPage");

    private String name;

    OldElement(String name){
        this.name = name;
    }

    public String getName() {
        return Locale.getSelectedLocale().getProperty(this.name);
    }
}
