package base.JavaThread.Javier_Fernández_González.chapter1.join;

import util.DateUtil;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-13  15:16
 * Author:wuxinrui
 */

public class VirtualNetWorkConnectionsLoader implements Runnable{
    @Override
    public void run() {
        System.out.printf("beginning netWork data sources loading: %s\n", DateUtil.CalendarNowTimeString(2));
        try{
            TimeUnit.SECONDS.sleep(6);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.printf("netWork data sources loading has finished : %s\n",DateUtil.CalendarNowTimeString(2));
    }

}
