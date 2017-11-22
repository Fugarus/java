package project.steam.enums;

public enum GenreGame {
     ACTION("action");

     private String name;

     GenreGame(String name){
         this.name = name;
     }

    public String getName() {
        return Locale.getSelectedLocale().getProperty(this.name);
    }
}
