package base.JavaThread.chapter4.Executor_Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description:
 * <p>
 * [你可以使用它运行并发任务并返回结果]
 * <p>
 * Callable：该接口包含call()方法。可以在方法内实现任务的代码逻辑。Callable接口是一个泛型接 口，
 * 这意味着必须指定call()方法的返回类型。
 * <p>
 * Future：该接口提供了一些方法来获取Callable对象的返回结果和管理Callable对象的状况
 * <p>
 * 如何实现可以返回结果的任务，并在执行器中执行这些任务
 * <p>
 * <p>
 * GET-version:
 * Date:2020-05-22  10:52
 * Author:wuxinrui
 */

public class Executor_Callable_case {
    public static void main(String[] args) {

//        线程池执行器-pool-2
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
//        集合记录 future-结果
        List<Future<Integer>> futureList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Integer number = random.nextInt(10);
            System.out.println("主线程-随机数："+number);
            //Callable-计算阶乘-返回结果
            FactorialCalculator factorialCalculator = new FactorialCalculator(number);
            //future-获取线程池执行器-结果
            Future<Integer> future = threadPoolExecutor.submit(factorialCalculator);
            //集合记录每次结果
            futureList.add(future);
        }
        do {
            System.out.println("main- 已完成的工作数量：" + threadPoolExecutor.getCompletedTaskCount());
            for (int i = 0; i < futureList.size(); i++) {
                Future future = futureList.get(i);
                System.out.printf("main : 工作  %d 是否结束： %s\n", i, future.isDone());
            }
            //完成数量-10 结束循环
            // getCompletedTaskCount=线程池执行器 完成数量
        } while (threadPoolExecutor.getCompletedTaskCount() < futureList.size());

        //获取10次结果
        for (int i = 0; i < futureList.size(); i++) {
            Future<Integer> future = futureList.get(i);
            Integer number = null;
            try {
                number = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            System.out.printf("main : task %d : %d \n ", i, number);
        }

        threadPoolExecutor.shutdown();


    }

}
