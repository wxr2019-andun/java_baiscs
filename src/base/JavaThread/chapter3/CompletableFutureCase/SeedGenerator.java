package base.JavaThread.chapter3.CompletableFutureCase;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-20  17:18
 * Author:wuxinrui
 */

public class SeedGenerator implements Runnable{
    private CompletableFuture<Integer> completableFuture;

    public SeedGenerator(CompletableFuture<Integer> completableFuture) {
        this.completableFuture = completableFuture;
    }
    //会休眠当前线程5s[5]，生成一个1和10之间的随机数字，然后调用resultCommunicator对象的complete()方法完成CompletableFuture：
    @Override
    public void run() {
        System.out.println("种子生成器:生成种子..  ");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int seed=(int) Math.rint(Math.random() * 10);
        System.out.printf("种子生成器:种子生成 %d\n",seed);
        completableFuture.complete(seed);
    }


}
