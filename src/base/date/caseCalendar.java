package base.date;

import util.DateUtil;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-13  14:14
 * Author:wuxinrui
 */

public class caseCalendar {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(DateUtil.CalendarNowTimeString(2));
        TimeUnit.SECONDS.sleep(10);
        System.out.println(DateUtil.CalendarNowTimeString(2));
    }
}
