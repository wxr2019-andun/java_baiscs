package base.JavaThread.chapter1.Local;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-14  9:27
 * Author:wuxinrui
 */

public class UnsafeCase {
    public static void main(String[] args) {
        //无线程本地变量- 线程结束时间改变
        //书上讲线程错误的写？ 是什么意思？（是值线程共享date变量-最后写入时间不一致嘛？  因为睡眠时其他线程启动 重新申请堆- 但是引用不一致呐？）
        VirtualUnsafeTask virtualUnsafeTack = new VirtualUnsafeTask();
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(virtualUnsafeTack);
            t1.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("-------------------------------------------------------------");
        //设置线程本地变量- 线程结束时间与开始时间一直
        virtualSafeTask virtualSafeTack = new virtualSafeTask();
        for (int i = 0; i < 10; i++) {
            Thread t2 = new Thread(virtualSafeTack);
            t2.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
