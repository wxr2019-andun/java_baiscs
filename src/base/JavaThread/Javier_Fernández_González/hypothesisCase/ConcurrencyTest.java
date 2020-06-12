package base.JavaThread.Javier_Fernández_González.hypothesisCase;

/**
 * Description:
 * GET-version:
 * Date:2020-05-21  9:48
 * Author:wuxinrui
 */

public class ConcurrencyTest {
    private static final long count = 100000000;
    private static int number=0;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }
//    这样不完全算线程执行的时间吧..
    private static void concurrency() throws InterruptedException {

        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int number=ConcurrencyTest.number;
                for (long i = 0; i < count; i++) {
                    number += 5;
                }
                ConcurrencyTest.number=number;
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency :" + time+"ms,b="+b+" a="+ConcurrencyTest.number);
    }
    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time+"ms,b="+b+",a="+a);
    }


}
