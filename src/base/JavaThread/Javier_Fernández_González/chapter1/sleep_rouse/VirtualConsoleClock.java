package base.JavaThread.Javier_Fernández_González.chapter1.sleep_rouse;

import util.DateUtil;

import java.util.concurrent.TimeUnit;

/**
 * Description: 线程休眠后唤醒- 任务- 使用异常中断线程执行
 * GET-version:
 * Date:2020-05-13  14:38
 * Author:wuxinrui
 */

public class VirtualConsoleClock implements Runnable{
    @Override
    public void run() {

        try{
            for (int i = 0; i <10 ; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(DateUtil.CalendarNowTimeString(2));
            }
        }catch (Exception e){
            System.out.println("the fileClock has been interrupted");
        }
    }

    public static void main(String[] args) {
        VirtualConsoleClock virtualConsoleClock = new VirtualConsoleClock();
        Thread thread = new Thread(virtualConsoleClock);
        thread.start();
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
