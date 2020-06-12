package base.JavaThread.Javier_Fernández_González.chapter3.phaserCase2;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-20  15:14
 * Author:wuxinrui
 */

public class PhaserStundent implements Runnable{
    private Phaser myPhaser;

    public PhaserStundent(Phaser myPhaser) {
        this.myPhaser = myPhaser;
    }

    @Override
    public void run() {
        System.out.printf("%s: 来做考试了吗. %s\n",Thread.currentThread().getName(),new Date());
        myPhaser.arriveAndAwaitAdvance();

        System.out.printf("%s: 要做第1个练习吗? .%s\n",Thread.currentThread().getName(),new Date());
        doExercise1();

        System.out.printf("%s: 第1个练习做完了吗.%s\n",Thread.currentThread().getName(),new Date());
        myPhaser.arriveAndAwaitAdvance();

        System.out.printf("%s: 要做第2个练习吗. %s\n",Thread.currentThread().getName(), new Date());
        doExercise2();

        System.out.printf("%s: 第2个练习做完了吗.%s\n",Thread.currentThread().getName(),new Date());
        myPhaser.arriveAndAwaitAdvance();

        System.out.printf("%s: 要做第3个练习吗.%s\n",Thread.currentThread().getName(),new Date());
        doExercise3();

        System.out.printf("%s: 考试完了 .%s\n", Thread.currentThread().getName(),new Date());
        myPhaser.arriveAndAwaitAdvance();

    }

    //该方法的线程将休眠一段随机时间，用于模拟答题耗时
    private void doExercise1() {
        try {
            Long duration=(long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void doExercise2() {
        try {
            Long duration=(long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void doExercise3() {
        try {
            Long duration=(long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
