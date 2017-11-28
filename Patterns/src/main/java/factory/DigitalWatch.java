package factory;

import java.util.Date;

public class DigitalWatch implements IWatch {
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}
