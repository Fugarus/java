package project.steam.enums;

public enum StoreCategory {
    GAMES("genre_tab");

    private String id;

    StoreCategory(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
