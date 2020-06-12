package base.JavaThread.Javier_Fernández_González.chapter3.CompletableFutureCase;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Description:
 * <p>
 * 创建一个用来生成种子任务，下一个任务用该种子来生成随机数字列表。然后，执行3个并行任务。
 * <p>
 * 步骤1：将计算随机数字列表中最接近1000的数字。
 * 步骤2：将计算随机数字列表中的最大数。
 * 步骤3：将计算随机数字列表中，最大数与最小数的平均值。
 * <p>
 *
 *
 * thenApplyAsync
 *
 *
 * GET-version:
 * Date:2020-05-20  17:16
 * Author:wuxinrui
 */

public class CompletableFutureCase {
    public static void main(String[] args) {

        System.out.printf("主方法 启动\n");
        CompletableFuture<Integer> seedFuture = new CompletableFuture<>();
        Thread seedThread = new Thread(new SeedGenerator(seedFuture));
        seedThread.start();

        System.out.printf("主方法 获取种子\n");
        int seed = 0;
        try {
            seed = seedFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.printf("主方法 中的种子是：  %d\n", seed);

        System.out.printf("主方法 启动数字生成器列表（百万个随机数字的列表） \n");
        NumberListGenerator task = new NumberListGenerator(seed);
        CompletableFuture<List<Long>> startFuture = CompletableFuture.supplyAsync(task);

        //步骤1：将计算随机数字列表中最接近1000的数字。
        System.out.printf("主方法 启动步骤1 \n");
        CompletableFuture<Long> step1Future = startFuture.thenApplyAsync(list -> {
                    System.out.printf("%s:步骤1 - 启动\n",Thread.currentThread().getName());
                    long selected = 0;
                    long selectedDistance = Long.MAX_VALUE;
                    long distance;
                    for (Long number : list) {
                        distance = Math.abs(number - 1000);
                        if (distance < selectedDistance) {
                            selected = number;
                            selectedDistance = distance;
                        }
                    }
                    System.out.printf("%s:步骤1(随机数字列表中最接近1000的数字) 结果  %d\n",Thread.currentThread().getName(), selected);
                    return selected;
                });

        //步骤2：将计算随机数字列表中的最大数。
        System.out.printf("主方法 启动步骤2 \n");
        CompletableFuture<Long> step2Future = startFuture.thenApplyAsync(list -> list.stream().max(Long::compare).get());
        CompletableFuture<Void> write2Future = step2Future.thenAccept(selected -> {
            System.out.printf("%s: 步骤2（随机数字列表中的最大数。） 结果  %d\n",Thread.currentThread().getName(), selected);
          });

        System.out.printf("主方法 启动步骤3\n");
        NumberSelector numberSelector = new NumberSelector();
        CompletableFuture<Long> step3Future = startFuture.thenApplyAsync(numberSelector);

        System.out.printf("Main: 等待步骤三 执行完成\n");
        CompletableFuture<Void> waitFuture = CompletableFuture.allOf(step1Future, write2Future, step3Future);

        CompletableFuture<Void> finalFuture = waitFuture.thenAcceptAsync((param) -> {
            System.out.printf("Main: CompletableFuture 示例已经完成.");
        });
        finalFuture.join();

    }

}
