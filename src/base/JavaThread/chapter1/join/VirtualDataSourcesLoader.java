package base.JavaThread.chapter1.join;

import util.DateUtil;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-13  15:10
 * Author:wuxinrui
 */

public class VirtualDataSourcesLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("beginning data sources loading: %s\n",DateUtil.CalendarNowTimeString(2));
       try{
           TimeUnit.SECONDS.sleep(4);
       }catch (Exception e){
           e.printStackTrace();
       }
        System.out.printf("data sources loading has finished : %s\n",DateUtil.CalendarNowTimeString(2));
    }

}
