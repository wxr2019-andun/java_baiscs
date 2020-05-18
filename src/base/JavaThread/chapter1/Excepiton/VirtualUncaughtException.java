package base.JavaThread.chapter1.Excepiton;

/**
 * Description:
 * GET-version:
 * Date:2020-05-13  20:08
 * Author:wuxinrui
 */

public class VirtualUncaughtException implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("an exception has been captured \n");
        System.out.printf("thread : %s \n",t.getId());
        System.out.printf("exception %s : %s \n",e.getClass().getName(),e.getMessage());

        System.out.printf("Stack Trace: \n");
        e.printStackTrace(System.out);
        System.out.printf("thread status %s\n",t.getState());
    }

}
