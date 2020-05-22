package base.JavaThread.chapter4.Executor_10;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-22  17:56
 * Author:wuxinrui
 */

public class ReportGenerator implements Callable<String> {
    private final String sender;
    private final String title;

    public ReportGenerator(String sender, String title) {
        this.sender = sender;
        this.title = title;
    }

    @Override
    public String call() throws Exception {
        long duration=(long)(Math.random()*10);
        System.out.printf("%s_%s 报告生成器 : 生成-报告 持续时间 %s 秒\n",sender,title,duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String str = sender+":"+title;
        return str;
    }

}
