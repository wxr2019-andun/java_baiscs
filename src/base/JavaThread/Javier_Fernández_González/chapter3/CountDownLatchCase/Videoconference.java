package base.JavaThread.Javier_Fernández_González.chapter3.CountDownLatchCase;

import java.util.concurrent.CountDownLatch;

/**
 * Description:
 * GET-version:
 * Date:2020-05-19  16:04
 * Author:wuxinrui
 */

public class Videoconference implements Runnable{
    private final CountDownLatch countDownLatch;//闭锁

    public Videoconference(int number) {
        countDownLatch = new CountDownLatch(number);
    }



    @Override
    public void run() {
        System.out.printf("视频会议: 初始化 %d 参与者.\n",countDownLatch.getCount());
        try {
            countDownLatch.await();//开始等带 所有人
            System.out.println("视频会议:所有与会者都已到场 \n");
            System.out.println("VideoConference: Let's start.. \n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void arrive(String name){
        System.out.printf(" %s : 已抵达 \n",name);
        countDownLatch.countDown();// 减少锁存器计数
        System.out.printf("视频会议: 等待 %d 参与者.\n",countDownLatch.getCount());
    }

}
