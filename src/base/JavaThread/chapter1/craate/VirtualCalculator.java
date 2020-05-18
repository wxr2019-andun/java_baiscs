package base.JavaThread.chapter1.craate;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Description: 线程数组 获取20000以内 奇数个数 （练习线程创建）
 * GET-version:
 * Date:2020-05-12  16:30
 * Author:wuxinrui
 */

public class VirtualCalculator implements Runnable {
    //线程数组 获取20000以内 奇数个数
    @Override
    public void run() {
        long i=1;
        long isQ=0;
        long max=20000;
        System.out.println("thread"+Thread.currentThread().getName()+"_____stares");
        while (i<=max){
            if(isPrime(i)){
                isQ++;
            }
            i++;
        }
        System.out.println("threadName:"+Thread.currentThread().getName()+"====number:"+isQ);
    }

    public static void main(String[] args) {


        System.out.println("Minimum Priority: " + Thread.MIN_PRIORITY);
        System.out.println("Maximum Priority: " + Thread.MAX_PRIORITY);
        System.out.println("Normal Priority: " + Thread.NORM_PRIORITY);

        //创建线程,线程状态 数组长度为10
        Thread[] thread;
        Thread.State[] states;
        thread = new Thread[10];
        states = new Thread.State[10];

        //创建线程优先级-名字
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new VirtualCalculator());
            if ((i % 2) == 0) {
                thread[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                thread[i].setPriority(Thread.MIN_PRIORITY);
            }
            thread[i].setName("threadName:" + i);
        }

        try{
            //启动线程前 将线程数组状态写入文件
            //FileWriter file = new FileWriter("D:\\dataLog.txt");
            PrintWriter pw = null;
            pw = new PrintWriter(new FileWriter(new File("D:\\file.txt")),true);
            for (int i = 0; i <10 ; i++) {
                pw.println("main:Stats of Thread"+i+":"+thread[i].getState());
                states[i]=thread[i].getState();
            }


            //启动
            for (int i = 0; i < 10; i++) {
                thread[i].start();
            }


            //不懂这里 布尔的用法..  懂了用来控制循环的
            boolean b  = false;
            while (!b){
                for (int i = 0; i <10 ; i++) {
                    //若 两种状态不同记录 此线程和x状态的数据
                    if(thread[i].getState()!=states[i]){
                        TInfo(pw,thread[i],states[i]);
                        states[i]=thread[i].getState();
                    }
                }
                b=true;
                for (int i = 0; i <10 ; i++) {
                    b=b&&(thread[i].getState()== Thread.State.TERMINATED);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //判断奇数
    private static boolean isPrime(long num) {
        //1==奇数返回 true
        if (num<2) {
            return true;
        }
        //循环 num取于i=0 返回false
        for (int i = 2; i < num; i++) {
            if((num%i)==0){
                return false;
            }
        }
        //返回 true
        return true;
    }

    //记录线程运行时状态
    private static void TInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("main: ID %d - %s \n", thread.getId(), thread.getName());
        pw.printf("main: priority: %d\n", thread.getPriority());
        pw.printf("main: old states: %s\n", state);
        pw.printf("main: new status: %s\n", thread.getState());
        pw.printf("************************\n");
    }


}
