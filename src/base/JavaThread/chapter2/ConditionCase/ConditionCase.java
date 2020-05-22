package base.JavaThread.chapter2.ConditionCase;

/**
 * Description: Condition接口为开发者提供了把线程挂起并且唤醒的机制。

 * GET-version:
 * Date:2020-05-15  15:59
 * Author:wuxinrui
 */

public class ConditionCase {
    public static void main(String[] args) {
// 100行- 一行-10列
        FileMock mock = new FileMock(100, 10);

//缓存20行
        Buffer buffer = new Buffer(20);
        ProducerC producer = new ProducerC(mock, buffer);

        Thread producerThread = new Thread(producer,"Producer");
        ConsumerC consumers[] = new ConsumerC[3];
        Thread consumersThreads[] = new Thread[3];

//        生产者-1  消费者-3
        for (int i=0; i<3; i++){
            consumers[i] = new ConsumerC(buffer);
            consumersThreads[i] = new Thread(consumers[i],"Consumer "+i);
        }

        producerThread.start();
        for (int i = 0; i< 3; i++){
            consumersThreads[i].start();
        }


/*
        FileMock fileMock = new FileMock(100,10);
        Buffer buffer = new Buffer(20);
        ProducerC producerC = new ProducerC(fileMock,buffer);
        Thread thread = new Thread(producerC,"producerC");
        ConsumerC[] consumerArr = new ConsumerC[3];
        Thread[] threadArr = new Thread[3];
        for (int i = 0; i < 3; i++) {
            consumerArr[i] = new ConsumerC(buffer);
            threadArr[i] = new Thread(consumerArr[i], "consumerArr-index" + i);
        }
        thread.start();
        for (int i = 0; i < 3; i++) {
            threadArr[i].start();
        }
 */


    }
}
