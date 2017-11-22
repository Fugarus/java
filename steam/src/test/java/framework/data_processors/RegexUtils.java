package framework.data_processors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    public static int getCountFindElements(final Matcher matcher){
        int countNode=0;
        while (matcher.find()){
            countNode++;
        }
        return countNode;
    }

    public static Matcher getMatcherForString(String regex,String string){
        return Pattern.compile(regex).matcher(string);
    }

    public static String getFindElementFromString(String regex,String string){
        Matcher matcher=getMatcherForString(regex,string);
        if(matcher.find())
            return string.substring(matcher.start(),matcher.end());
        return "";
    }
}
