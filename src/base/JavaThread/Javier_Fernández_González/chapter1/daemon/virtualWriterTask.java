package base.JavaThread.Javier_Fernández_González.chapter1.daemon;


import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-13  15:57
 * Author:wuxinrui
 */

public class virtualWriterTask implements Runnable {
    private Deque<virtualEvent> deque;

    public virtualWriterTask(Deque<virtualEvent> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            virtualEvent virtualEvent = new virtualEvent();
            virtualEvent.setDate(new Date());
            virtualEvent.setEvent(String.format("the thread: %s", Thread.currentThread().getId()));
            deque.addFirst(virtualEvent);
            System.out.println(deque.size());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
