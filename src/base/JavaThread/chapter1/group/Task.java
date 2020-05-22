package base.JavaThread.chapter1.group;

import java.util.Random;

/**
 * Description:
 * GET-version:
 * Date:2020-05-14  9:57
 * Author:wuxinrui
 */

public class Task implements Runnable {

    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        //
        while (true) {
            //int numero=Integer.parseInt("TTT");

            result = 1000 / ((int) (random.nextDouble() * 1000000000));

            //System.out.println("result:"+result);
            //System.out.println("threadState:"+Thread.currentThread().getState());



            if (Thread.currentThread().interrupted()) {
                System.out.printf("%d : Interrupted \n", Thread.currentThread().getId());
                return;
            }
        }
    }
}
