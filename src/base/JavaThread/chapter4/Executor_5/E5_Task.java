package base.JavaThread.chapter4.Executor_5;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-22  14:29
 * Author:wuxinrui
 */

public class E5_Task implements Callable<E5_result> {
    private final String name;

    public E5_Task(String name) {
        this.name = name;
    }

    @Override
    public E5_result call() throws Exception {
        System.out.println(name+":Starting ");
        long duration=(long)(Math.random()*10);

        System.out.println(name+"：等待秒"+duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int value=0;
        for (int i = 0; i < 5; i++) {
//            value=(int) Math.random()*100;//错- v=0
            value=(int)(Math.random()*10);

        }
        E5_result e5_result = new E5_result();
        e5_result.setName(name);
        e5_result.setValue(value);
        System.out.println(name+":end ");
        return e5_result;
    }
}
