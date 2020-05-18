package base.JavaThread.chapter2.lockCase;

/**
 * Description:
 * GET-version:
 * Date:2020-05-15  12:05
 * Author:wuxinrui
 */

public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
//        System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
        System.out.println("线程开始打印 :"+Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.println("线程执行完毕 :"+Thread.currentThread().getName());
//        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());

    }
}
