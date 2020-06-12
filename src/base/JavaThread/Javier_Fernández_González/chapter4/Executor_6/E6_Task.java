package base.JavaThread.Javier_Fernández_González.chapter4.Executor_6;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Description:
 * GET-version:
 * Date:2020-05-22  14:59
 * Author:wuxinrui
 */

public class E6_Task implements Callable<String> {
    private final String name;

    public E6_Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("用户"+name+" 启动时间："+new Date());
        return "hey Thread";
    }
}
