package factory;

import java.util.Date;


public class ReverseWatch implements IWatch{
    @Override
    public void showTime() {
        System.out.println(new StringBuilder(new Date().toString()).reverse().toString());
    }
}

