package base.JavaThread.Javier_Fernández_González.chapter4.Executor_4;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 *
 * 运行多个并发任务来解决一个问题-关心第一个返回结果
 *
 * Demo: 用两种机制来试验和验证用户。如果其中一种 能验证用户，则完成当前用户的验证
 *
 *
 * invokeAny(Collection<? extends Callable> tasks, longtimeout, TimeUnit unit)：
 * 该方法执行全部 任务并返回第一个正常运行结束且未抛出异常和未超过设定时间的任务执行结果。TimeUnit类对象是
 * 一个枚举类，它包括DAYS、HOURS、MICROSECONDS、MILLISECONDS、MINUTES、NANOSECONDS、和 SECONDS。
 *
 *
 * GET-version:
 * Date:2020-05-22  13:48
 * Author:wuxinrui
 */

public class E4Case {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.printf("run: %d starting \n",i);

            String userName="name";
            String passWord="ps";

            UserValidator uv1 = new UserValidator("uv1");
            UserValidator uv2 = new UserValidator("uv2");

            ValidatorTask vt1 = new ValidatorTask(uv1,userName,passWord);
            ValidatorTask vt2 = new ValidatorTask(uv2,userName,passWord);
            ArrayList<ValidatorTask> arrlist = new ArrayList<>();
            arrlist.add(vt1);arrlist.add(vt2);

            ExecutorService executorService = (ExecutorService) Executors.newCachedThreadPool();
            String result;
            try {
                result=executorService.invokeAny(arrlist);
                System.out.println("成功结果："+result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            executorService.shutdown();

            System.out.printf("run: %d end \n",i);
        }



    }
}
