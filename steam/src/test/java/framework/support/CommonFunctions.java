package framework.support;

import java.util.List;

public class CommonFunctions{

    public static String generateText(){
        String symbols = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        StringBuilder randString = new StringBuilder();
        int count = 20+(int)(Math.random()*20);
        for(int i=0;i<count;i++) {
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        return randString.toString();
    }

    public static Object getRandomItem(List array) {
        //TODO if( array.length == 0){}
        int itemIndex = (int)(Math.random()*array.size());
        return array.get(itemIndex);
    }
}
