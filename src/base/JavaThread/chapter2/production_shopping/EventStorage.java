package base.JavaThread.chapter2.production_shopping;

import util.DateUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * GET-version:
 * Date:2020-05-15  10:19
 * Author:wuxinrui
 */

public class EventStorage {
    private int maxSize;
    private Queue<String> storage;

    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<>();
    }
// wait会跳出代码嘛？   不跳出顺序执行 睡眠线程就没有意义了
//    懂了-这里一直取值-直到 条件通过 后执行代码.那这里wait意义不大呐

    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.offer(DateUtil.CalendarNowTimeString(2));
        System.out.println("set : "+storage.size());
        notify();
    }
    public synchronized void get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String str = storage.poll().toString();
        System.out.printf("get : %d : %s \n ",storage.size(),str);
        notify();
    }

}
