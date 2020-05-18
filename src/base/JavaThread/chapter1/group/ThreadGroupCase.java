package base.JavaThread.chapter1.group;

/**
 * Description: 线程数组 异常控制- 这里demo除了小问题- 中断的状态没有改变？ 或许demo给的代码有错误
 * 这里应该是中断 或者判断中断除了点问题-和jdk版本有关系嘛？
 *
 * GET-version:
 * Date:2020-05-14  10:05
 * Author:wuxinrui
 */

public class ThreadGroupCase {
    public static void main(String[] args) {
        VirtualMyThreadGroup virtualMyThreadGroup = new VirtualMyThreadGroup("virtualMyThreadGroup");
        Tack tack = new Tack();
        //int off = Runtime.getRuntime().availableProcessors();
        int off=4;
        for (int i = 0; i <off ; i++) {
            Thread t = new Thread(virtualMyThreadGroup,tack);
            t.start();
        }

        System.out.printf("number of threads %d \n",virtualMyThreadGroup.activeCount());
        System.out.printf("information about the thread group \n");
        virtualMyThreadGroup.list();

        Thread[] threads = new Thread[virtualMyThreadGroup.activeCount()];
        virtualMyThreadGroup.enumerate(threads);
        for (int i = 0; i < virtualMyThreadGroup.activeCount(); i++) {
            System.out.printf("thread %s : %s \n",threads[i].getName(),threads[i].getState());
        }
    }
}
