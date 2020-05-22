package base.JavaThread.chapter1.Local;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-14  9:11
 * Author:wuxinrui
 */

public class VirtualUnsafeTask implements Runnable{
    private Date startDate;
    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("starting thread : %s : %s\n",Thread.currentThread().getId(),startDate);
        try{
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.printf("finished thread : %s : %s\n",Thread.currentThread().getId(),startDate);
    }

}
