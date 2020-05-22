package base.JavaThread.chapter1.daemon;

import java.util.Date;
import java.util.Deque;

/**
 * Description:
 * GET-version:
 * Date:2020-05-13  16:31
 * Author:wuxinrui
 */

public class virtualCleanerTask extends Thread {
    private Deque<virtualEvent> deque;

    public virtualCleanerTask(Deque<virtualEvent> deque) {
        this.deque = deque;
        setDaemon(true);//***
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }

    }

    // 启动时间 与 队列内容最新时间相聚超过10s 线程任务跳出循环
    public void clean(Date date) {
        long difference;
        boolean b;
        if (deque.size() == 0) {
            return;
        }

        b = false;
        do {
            virtualEvent ve = deque.getLast();
            difference = date.getTime() - ve.getDate().getTime();
            if (difference > 10000) {
                System.out.printf("cleaner : %s\n", ve.getEvent());
                deque.removeLast();
                b = true;
            }
        } while (difference > 10000);
        if (b) {
            System.out.printf("cleaner : size of the queue : %d \n", deque.size());
        }
    }


}
