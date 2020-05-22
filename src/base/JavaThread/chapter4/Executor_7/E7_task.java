package base.JavaThread.chapter4.Executor_7;

import java.util.Date;

/**
 * Description:
 * GET-version:
 * Date:2020-05-22  15:28
 * Author:wuxinrui
 */

public class E7_task implements Runnable{
    private final String name;

    public E7_task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+" 执行时间  ："+new Date());
    }
}
