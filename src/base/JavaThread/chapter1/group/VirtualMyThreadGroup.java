package base.JavaThread.chapter1.group;

/**
 * Description:
 * GET-version:
 * Date:2020-05-14  9:52
 * Author:wuxinrui
 */

public class VirtualMyThreadGroup extends ThreadGroup{
    public VirtualMyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("the thread %s has thrown and Exception \n",t.getId());
        e.printStackTrace(System.out);
        System.out.printf("Terminating the rest of the Threads %s has thrown and Exception \n");
        t.interrupt();

    }

}
