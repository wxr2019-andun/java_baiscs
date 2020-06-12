package base.JavaThread.Javier_Fernández_González.chapter2.ConditionCase;

import java.util.Random;

/**
 * Description:
 * GET-version:
 * Date:2020-05-15  16:48
 * Author:wuxinrui
 */

//

public class ConsumerC implements Runnable{
    private Buffer buffer;

    public ConsumerC(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.hasPendingLines()) {
            String line = buffer.get();
            System.out.printf("Cname- %s get- %s \n",Thread.currentThread().getName(),line);
            processLine(line);
            System.out.println("over---"+Thread.currentThread().getName());
        }
    }
    private void processLine(String line) {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
