package base.JavaThread.chapter3.SemaphoreCase;

/**
 * Description:
 * GET-version:
 * Date:2020-05-19  11:24
 * Author:wuxinrui
 */

public class SemaphoreCase {
    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++) {
//            boolean b =true;
//            if (b) {
//                System.out.println(i);
//                break;
//            }
//        }

//        PrintQueue printQueue = new PrintQueue();
//        for (int i = 0; i < 6; i++) {
//            printQueue.printJob(new Object());
//        }

        PrintQueue  printQueue = new PrintQueue();
        SemaphoreJob semaphoreJobCase = new SemaphoreJob(printQueue);
        int off =20;
        Thread[] threads = new Thread[off];
        for (int i = 0; i < off; i++) {
         threads[i]= new Thread(new SemaphoreJob(printQueue),"T"+i);
        }

        for (int i = 0; i < off; i++) {
            threads[i].start();
        }


//
    }
}
