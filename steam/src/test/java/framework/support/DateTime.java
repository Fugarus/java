package framework.support;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime{
    private static String templateEndTime="2013-12-31 00:58:00";
    private static String templateStartTime="2013-01-01 00:00:00";
    private static String templateDate="yyyy-MM-dd hh.mm.ss.SSS";
    private static long beginTime = Timestamp.valueOf(templateStartTime).getTime();
    private static long endTime = Timestamp.valueOf(templateEndTime).getTime();

    private static long getRandomTimeBetweenTwoDates () {
        long diff = endTime - beginTime + 1;
        return beginTime + (long) (Math.random() * diff);
    }

    public static String getRandomDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(templateDate);
        return dateFormat.format(new Date(getRandomTimeBetweenTwoDates()));
    }

    public static String getRandomDateEnd(String date){
        for(int i=0;i<10;i++){
            String endDate=getRandomDate();
            if (endDate.compareTo(date)>0){
                return endDate;
            }
        }
        return templateEndTime;
    }

    public static String getCurrentDate(){
        return new SimpleDateFormat(templateDate).format(new Date());
    }
}
