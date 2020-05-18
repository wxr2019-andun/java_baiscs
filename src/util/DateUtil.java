package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Description:
 * GET-version:
 * Date:2020-05-13  13:55
 * Author:wuxinrui
 */

public class DateUtil {
    public static String CalendarNowTimeString(int tyep) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date dates = calendar.getTime();
        String result;
        switch (tyep) {
            case 1:
                result = DateString_day(dates);
                return result;
            case 2:
                result = DateString_milli(dates);
                return result;

        }
        return null;
    }

    public static String DateString_day(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dates = simpleDateFormat.format(date);
        return dates;
    }

    public static String DateString_milli(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dates = simpleDateFormat.format(date);
        return dates;
    }
}
