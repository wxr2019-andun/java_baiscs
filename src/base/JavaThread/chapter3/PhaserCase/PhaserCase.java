package base.JavaThread.chapter3.PhaserCase;

import java.util.concurrent.Phaser;

/**
 * Description: 【执行阶段性并发任务】-当一些并发任务需要分步骤执行时，该机制便显得非常有用

 * 本节将介绍如何用Phaser类来同步3个并发任务。这3个任务将在3个不同的文件夹及其子文件夹中 搜索以.log为扩展名并在过去24小时内修改过的文件。这个任务可以分为3步来处理。
 * 得到指定文件夹及其子文件夹中以.log为扩展名的文件列表。
 * 对第一步中得到的列表进行筛选，删除修改时间超过24小时的文件。
 * 在控制台中输出结果。
 *
 * arriveAndAwaitAdvance()?
 *
 * 但这三个线程 彼此有什么关联吗？
 * 是最终将 每个线程-得到的结果整合到一起嘛？
 *
 * -线程本质还是轮流执行-在cpu上..
 *
 * GET-version:
 * Date:2020-05-19  18:33
 * Author:wuxinrui
 */

public class PhaserCase {
    public static void main(String[] args) {
//        创建1个拥有3个同步参与者的Phaser对象：
        Phaser phaser = new Phaser(3);
        FileSearch system = new FileSearch("C:\\Windows", "log", phaser);
        FileSearch apps = new FileSearch("C:\\Program Files", "log", phaser);
        FileSearch documents = new FileSearch("C:\\Documents And Settings", "log", phaser);


        Thread systemThread = new Thread(system, "System");
        systemThread.start();
        Thread appsThread = new Thread(apps, "Apps");
        appsThread.start();
        Thread documentsThread = new Thread(documents, "Documents");
        documentsThread.start();

        try {
            systemThread.join();
            appsThread.join();
            documentsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //31．调用Phaser对象的isTerminated()方法获取其是否已经终止的标志，并输出：
        System.out.println("终止: " + phaser.isTerminated());

    }
}
