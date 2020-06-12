package base.JavaThread.Javier_Fernández_González.chapter4.Executor_RejectedExecutionHandler;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description:
 * GET-version:
 * Date:2020-05-21  18:32
 * Author:wuxinrui
 */

public class RejectedTaskController implements RejectedExecutionHandler {

//中实现接口的rejectedExecution()方法，然后打印出被拒绝的任务名称和执行器的名称与状态：
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("拒绝任务控制器 : 当前工作 %s 被拒绝 \n",r.toString());
        System.out.printf("拒绝任务控制器 : %s \n",executor.toString());
        System.out.printf("拒绝任务控制器 :  终止 %s\n",executor.isTerminating());
        System.out.printf("拒绝任务控制器 :  终止 %s\n",executor.isTerminated());
    }
}
