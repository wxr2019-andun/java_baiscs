package base.JavaThread.Javier_Fernández_González.chapter4.Executor_9;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-22  16:58
 * Author:wuxinrui
 */

public class E9_Case {
    public static void main(String[] args) {


        ExecutorService executor = Executors.newCachedThreadPool();
        ResultTask resultTasks[] = new ResultTask[5];
        for (int i = 0; i < 5; i++) {
            ExecutableTask executableTask = new ExecutableTask("Task " + i);
            resultTasks[i] = new ResultTask(executableTask);
            executor.submit(resultTasks[i]);
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        for (int i = 0; i < resultTasks.length; i++) {
            resultTasks[i].cancel(true);
        }

        for (int i = 0; i < resultTasks.length; i++) {
            try {
                if (!resultTasks[i].isCancelled()) {
                    System.out.printf("%s\n", resultTasks[i].get());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();

//        ExecutorService executor= Executors.newCachedThreadPool();
//        ResultTask[] resultTask = new ResultTask[5];
//        for (int i = 0; i < 5; i++) {
//            ExecutableTack executableTack =  new ExecutableTack("task:"+i);
//            resultTask[i]=new ResultTask(executableTack);
//            executor.submit(resultTask[i]);
//        }
//
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        for (int i = 0; i < resultTask.length; i++) {
//            resultTask[i].cancel(true);
//        }
//
//        for (int i = 0; i < resultTask.length; i++) {
//            try {
//                if(!resultTask[i].isCancelled()){
//                    System.out.println(resultTask[i].get());
//                }
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
//        executor.shutdown();
    }
}
