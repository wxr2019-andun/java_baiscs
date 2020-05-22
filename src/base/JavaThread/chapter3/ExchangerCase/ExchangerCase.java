package base.JavaThread.chapter3.ExchangerCase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Description:

 生产者-消费者是经典的并发问题：有一块公共的数据缓冲区，
 若干个生产者向缓冲区提供数据，而若干个消费者从缓冲区中提取数据。
 Exchanger只能在两个线程间同步，因此它适用于仅有一个生产者和一个消费者的生产者-消费者问题

 [Java并发API提供了在两个并发任务间进行数据交换的工具类。具体来说，Exchanger工具类允许在两
 个线程间定义一个同步点，当两个线程到达该同步点时，它们能够交换内部的数据结构，使得第一个线
 程的数据结构传递给第二个线程，反之亦然。]


 如何使用Exchanger来解决仅有一个生产者和一个消费者的生产者-消费者问题。

 * GET-version:
 * Date:2020-05-20  16:00
 * Author:wuxinrui
 */

public class ExchangerCase {

    public static void main(String[] args) {
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();

        Exchanger<List<String>> exchanger = new Exchanger<>();

        E_producer e_producer = new E_producer(buffer1,exchanger);
        E_consumer e_consumer = new E_consumer(buffer2,exchanger);
        Thread t1 = new Thread(e_producer);
        Thread t2 = new Thread(e_consumer);
        t1.start();
        t2.start();
    }
}
