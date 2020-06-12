package base.JavaThread.Javier_Fernández_González.chapter1.craate;

/**
 * Description: 查看线程状态-为中断跳出循环结束线程
 * GET-version:
 * Date:2020-05-13  9:37
 * Author:wuxinrui
 */

public class VirtualPrimeGenerator extends Thread {
    @Override
    public void run() {
        long number = 1l;
        while(true) {
            //number 为奇数打印 number
            if (isPrime(number)) {
                System.out.printf("number: %d is prime\n", number);
            }
            // 若线程状态 为中断
            if (this.isInterrupted()) {
                //System.out.printf("threadStated is: %s\n", this.getState());
                System.out.println("the prime generator has been isInterrupted");
                return;
            }
            number++;
        }

        //long number = 1L;
        //while (true) {
        //    if (isPrime(number)) {
        //        System.out.printf("Number %d is Prime\n", number);
        //    }
        //    if (isInterrupted()) {
        //        System.out.printf("The Prime Generator has been Interrupted");
        //        return;
        //    }
        //    number++;
        //}

    }


    private static boolean isPrime(long num) {
        //1==奇数返回 true
        if (num < 2) {
            return true;
        }
        //循环 num取于i=0 返回false
        for (int i = 2; i < num; i++) {
            if ((num % i) == 0) {
                return false;
            }
        }
        //返回 true
        return true;
    }

    public static void main(String[] args) throws Exception {

        //Thread task = new VirtualPrimeGenerator();
        //task.start();
        //try {
        //    Thread.sleep(5000);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        //task.interrupt();
        //System.out.printf("Main: Status of the Thread: %s\n",task.getState());
        //System.out.printf("Main: isInterrupted: %s\n",task.isInterrupted());
        //System.out.printf("Main: isAlive: %s\n", task.isAlive());

        Thread thread = new VirtualPrimeGenerator();
        thread.start();
        //主线程启动5秒 后中断线程
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //改变线程状态-为中断

        thread.interrupt();
        System.out.printf("Main: Status of the Thread: %s\n", thread.getState());
        System.out.printf("Main: isInterrupted: %s\n", thread.isInterrupted());
        System.out.printf("Main: isAlive: %s\n", thread.isAlive());




    }
}
