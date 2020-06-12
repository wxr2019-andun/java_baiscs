package base.JavaThread.Javier_Fernández_González.chapter4.Executor_9;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-22  16:59
 * Author:wuxinrui
 */

public class ExecutableTask implements Callable<String> {
    private final String name;

    public ExecutableTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String call() throws Exception {
        long duration=(long)(Math.random()*10);
        System.out.println(name+"：等待秒"+duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "oh-"+name;
    }
}
