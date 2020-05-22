package base.JavaThread.hypothesisCase;

/**
 * Description:
 *
 *
 *
 *
 *
 * GET-version:
 * Date:2020-05-21  9:39
 * Author:wuxinrui
 */

public class hypothesisCase {
    private static long a;
    private static long b;
    private static long c;

    public static void main(String[] args) {

       Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                long n1 = hypothesisCase.a;
            }
        });
        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                long n1 = hypothesisCase.b;
            }
        });
        Thread t3 =  new Thread(new Runnable() {
            @Override
            public void run() {
                long n1 = hypothesisCase.c;
            }
        });
//        并行完成不同的代码块
        t1.start();t2.start();t3.start();
//        主方法等待3个线程运行完毕
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        将3个结果集- 最终处理
        long max = hypothesisCase.a+hypothesisCase.b+hypothesisCase.c;
    }

//    静态值传递 demo
//    private static long a=0;
//    public static void main(String[] args) {
//        long number = hypothesisCase.a;
//        System.out.println("run 1: "+number);
//        for (int i = 0; i < 50; i++) {
//            number+=number+i;
//            System.out.println(number);
//        }
//        hypothesisCase.a=number;
//        hypothesisCase.cases();
//        System.out.println("run 2 :"+hypothesisCase.a);
//    }
//    public static void cases(){
//        System.out.println("cases  n:"+hypothesisCase.a);
//        hypothesisCase.a=hypothesisCase.a-1000;
//    }
}

