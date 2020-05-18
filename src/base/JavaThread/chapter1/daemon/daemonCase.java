package base.JavaThread.chapter1.daemon;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Description: 线程tack 向队列写入内容 守护线程-清除过期队列内容
 * GET-version:
 * Date:2020-05-13  17:07
 * Author:wuxinrui
 */

public class daemonCase {
    public static void main(String[] args) {
        //System.out.println(Runtime.getRuntime().availableProcessors());
        //实例 队列
        Deque deque = new ConcurrentLinkedDeque();
        // 循环100次 写入队列
        virtualWriterTack virtualWriterTack = new virtualWriterTack(deque);
        //for (int i = 0; i <Runtime.getRuntime().availableProcessors() ; i++) {
        for (int i = 0; i <4 ; i++) {
        Thread t1 = new Thread(virtualWriterTack);
            t1.start();
        }

        //try{
        //    TimeUnit.SECONDS.sleep(3);
        //}catch (Exception e){
        //    e.printStackTrace();
        //}

        // 守护线程 删除队列 过期时间的元素
        virtualCleanerTack virtualCleanerTack = new virtualCleanerTack(deque);
        virtualCleanerTack.start();


    }
}